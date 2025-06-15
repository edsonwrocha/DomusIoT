<p align="center">
  <img src="docs/icon-DomusIoT.svg" alt="DomusIoT Logo" width="200"/>
</p>

<p align="center">
  <em>DomusIoT is an open source platform for remote control and scheduling of IoT devices. It offers a user-friendly web interface, real-time MQTT communication, and a scalable architecture.</em>
</p>

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Next.js](https://img.shields.io/badge/Next.js-000000?style=for-the-badge&logo=next.js&logoColor=white)
![Tailwind CSS](https://img.shields.io/badge/Tailwind_CSS-06B6D4?style=for-the-badge&logo=tailwind-css&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![C++](https://img.shields.io/badge/C++-00599C?style=for-the-badge&logo=c%2B%2B&logoColor=white)
![C](https://img.shields.io/badge/C-555555?style=for-the-badge&logo=c&logoColor=white)

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
