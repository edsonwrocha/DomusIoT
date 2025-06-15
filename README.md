<p align="center">
  <img src="docs/icon-DomusIoT.svg" alt="DomusIoT Logo" width="200"/>
</p>

<p align="center">
  <em>DomusIoT is an open source platform for remote control and scheduling of IoT devices. It offers a user-friendly web interface, real-time MQTT communication, and a scalable architecture.</em>
</p>

---

## ✨ Features
- Register, edit, and remove devices  
- Turn devices on and off remotely  
- Control 110V/220V loads (e.g., lights, relays)  
- Real-time monitoring via MQTT  
- Secure authentication using JWT  
- Web interface built with Java + Vaadin  
- Firmware for ESP32 using PlatformIO  

---

## 🧱 Tech Stack
- **Backend:** Java, Spring Boot, Vaadin  
- **Firmware:** C/C++, ESP32, ESP-IDF  
- **MQTT Broker:** Mosquitto  
- **Testing:** Python (Pytest, MQTT testing)  
- **Infrastructure:** Docker, AWS (EC2, RDS, S3), GitHub Actions  
- **Database:** MySQL  

---

## 🗂️ Project Structure
```text
iot-device-manager/
├── backend/ # Java backend (Spring Boot + Vaadin)
├── devices/ # ESP32 firmware code (C/C++)
├── tests/ # Automated tests (API, MQTT, integration)
├── infrastructure/ # Docker, Mosquitto config, AWS Terraform
├── docs/ # Technical documentation
├── .github/ # CI/CD with GitHub Actions
├── README.md
└── LICENSE
```

---

## 🚀 Purpose

Provide a general-purpose, extensible, and user-friendly platform for managing IoT devices — reducing dependency on proprietary systems and promoting an open, interoperable ecosystem.

---

## 🛠️ How to Contribute

1. Fork this repository  
2. Create a new branch: `git checkout -b my-feature`  
3. Commit your changes: `git commit -m 'feat: my new feature'`  
4. Push to your fork: `git push origin my-feature`  
5. Open a Pull Request  

---

## 📜 License

[MIT License](LICENSE)
