# 🎫 TicketManager

A Java-based incident management system designed to register and track incidents, with planned support for email and desktop notifications.

> ⚠️ **Work in Progress** — This project is currently under active development. The core CRUD is functional, but some features are still being implemented.

---

## 📌 About the Project

TicketManager is a CLI application built with plain Java and Maven, focused on incident lifecycle management. It allows users to open incidents, assign responsibles, classify impact levels, and track status — all persisted locally via JSON.

This project was built as part of a Java learning journey, following clean architecture principles and market-standard conventions.

---

## 🚀 Features

- [x] Interactive menu with CRUD operations
- [x] Incident registration with title, description, impact and responsible
- [x] Automatic timestamp on incident creation
- [x] Impact classification (`LOW`, `MEDIUM`, `HIGH`, `CRITICAL`)
- [x] Status tracking (`OPEN`, `IN_PROGRESS`, `RESOLVED`)
- [x] Incident log entries
- [x] JSON-based local persistence with Gson
- [x] Search by ID with Optional
- [x] Continuous menu loop with exit option
- [ ] Email notifications
- [ ] Desktop notifications

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
│               │   └── NotificacaoService.java (upcoming)
│               └── App.java
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

# Build and run (Linux/Mac)
mvn compile exec:java -Dexec.mainClass="com.ticketmanager.App"

# Build and run (Windows PowerShell)
mvn compile "-Dexec.mainClass=com.ticketmanager.App" exec:java
```

---

## 📐 Architecture

TicketManager follows a layered architecture based on the **Single Responsibility Principle (SRP)**:

- **Model** — Defines what an incident is (data structure and enums)
- **Repository** — Handles data persistence (read/write JSON)
- **Service** — Contains business logic and orchestrates actions
- **App** — Application entry point with interactive menu

---

## 📄 License

This project is intended for educational purposes.

---

> Developed by [Kelvin](https://github.com/Kxllvin) · Java Backend Student · 2026