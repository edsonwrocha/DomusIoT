package com.iotmanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iotmanager.dto.DeviceCommandDTO;
import com.iotmanager.model.Device;
import com.iotmanager.service.DeviceService;
import com.iotmanager.service.MqttService;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    private final DeviceService deviceService;
    private final MqttService mqttService;

    public DeviceController(DeviceService deviceService, MqttService mqttService) {
        this.deviceService = deviceService;
        this.mqttService = mqttService;
    }

    @GetMapping
    public List<Device> list() {
        return deviceService.getAllDevices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> get(@PathVariable Long id) {
        return deviceService.getDeviceById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Device device) {
        if (device.getSerial() == null || device.getSerial().isBlank()) {
            return ResponseEntity.badRequest().body("Serial is required.");
        }

        if (deviceService.serialExists(device.getSerial())) {
            return ResponseEntity.status(409).body("A device with this serial already exists.");
        }

        Device saved = deviceService.saveDevice(device);
        mqttService.subscribeToDevice(saved.getSerial());
        return ResponseEntity.ok(saved);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Device updatedDevice) {
        Optional<Device> existingOpt = deviceService.getDeviceById(id);
        if (existingOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Device existingDevice = existingOpt.get();

        if (updatedDevice.getSerial() == null || updatedDevice.getSerial().isBlank()) {
            return ResponseEntity.badRequest().body("Serial is required.");
        }

        boolean serialExists = deviceService.getAllDevices().stream()
            .anyMatch(d -> !d.getId().equals(id) && d.getSerial().equals(updatedDevice.getSerial()));
        if (serialExists) {
            return ResponseEntity.status(409).body("Another device already uses this serial.");
        }

        existingDevice.setSerial(updatedDevice.getSerial());
        deviceService.saveDevice(existingDevice);

        return ResponseEntity.ok(existingDevice);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        deviceService.deleteDevice(id);
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping("/{id}/command")
    public ResponseEntity<?> sendCommand(@PathVariable Long id, @RequestBody DeviceCommandDTO command) {
        Optional<Device> deviceOpt = deviceService.getDeviceById(id);
        if (deviceOpt.isEmpty()) return ResponseEntity.notFound().build();

        String deviceSerial = deviceOpt.get().getSerial(); // assumindo que existe um campo "serial"
        mqttService.publishCommand(deviceSerial, command);
        
        return ResponseEntity.ok("Comando enviado com sucesso.");
    }

}
