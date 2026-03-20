# 🎫 TicketManager

A Java-based incident management system designed to register, track, and notify teams about incidents in real time — with email and desktop notifications.

---

## 📌 About the Project

TicketManager is a desktop application built with plain Java and Maven, focused on incident lifecycle management. It allows users to open incidents, assign responsibles, classify impact levels, and receive instant notifications — all persisted locally via JSON.

This project is currently under active development as part of a Java learning journey, following clean architecture principles and market-standard conventions.

---

## 🚀 Features

- [x] Incident registration with title, description, impact, and responsible
- [x] Automatic timestamp on incident creation
- [x] Impact classification (`LOW`, `MEDIUM`, `HIGH`, `CRITICAL`)
- [x] Status tracking (`OPEN`, `IN_PROGRESS`, `RESOLVED`)
- [x] Incident log entries
- [x] JSON-based local persistence
- [ ] Email notifications
- [ ] Desktop notifications
- [ ] Service layer (in progress)

---

## 🏗️ Project Structure

```
ticketmanager/
├── src/
│   └── main/
│       └── java/
│           └── com/ticketmanager/
│               ├── model/
│               │   ├── Incident.java
│               │   ├── Status.java
│               │   └── Impacto.java
│               ├── repository/
│               │   └── IncidentRepository.java
│               ├── service/
│               │   ├── IncidentService.java
│               │   └── NotificacaoService.java
│               └── Main.java
├── data/
│   └── incidents.json
└── pom.xml
```

---

## 🛠️ Technologies

| Technology | Purpose |
|---|---|
| Java 17 | Core language |
| Maven | Build and dependency management |
| Gson 2.10.1 | JSON serialization/deserialization |
| Jakarta Mail | Email notifications (upcoming) |
| java.awt.SystemTray | Desktop notifications (upcoming) |

---

## ⚙️ How to Run

### Prerequisites

- Java 17+
- Maven 3.8+

### Steps

```bash
# Clone the repository
git clone https://github.com/Kxllvin/ticketmanager.git

# Navigate to the project folder
cd ticketmanager

# Build the project
mvn clean compile

# Run the application
mvn exec:java -Dexec.mainClass="com.ticketmanager.Main"
```

---

## 📐 Architecture

TicketManager follows a layered architecture based on the **Single Responsibility Principle (SRP)**:

- **Model** — Defines what an incident is (data structure)
- **Repository** — Handles data persistence (read/write JSON)
- **Service** — Contains business logic and orchestrates actions
- **Main** — Application entry point

---

## 📄 License

This project is intended for educational purposes.

---

> Developed by [Kelvin](https://github.com/Kxllvin) · Java Student · 2025
