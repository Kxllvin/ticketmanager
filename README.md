# 🎫 TicketManager v1.0

A Java-based incident management system designed to register, track, and document the full lifecycle of incidents — from opening to resolution.

> ✅ **v1.0 Released** — Core incident management system is complete and fully functional.

---

## 📌 About the Project

TicketManager is a desktop application built with plain Java and Maven, focused on incident lifecycle management. It allows teams to open incidents, assign responsibles, classify impact levels, track status changes, and document resolutions — all persisted locally via JSON.

This project was built as part of a Java learning journey, following clean architecture principles and market-standard conventions.

---

## 🚀 Features

- [x] Interactive menu with full CRUD operations
- [x] Incident registration with title, description, impact and responsible
- [x] Automatic timestamp on incident creation
- [x] Impact classification (`LOW`, `MEDIUM`, `HIGH`, `CRITICAL`)
- [x] Automatic status `OPEN` on incident creation
- [x] Automatic status change `OPEN → IN_PROGRESS` on update
- [x] Incident update with full change history log
- [x] Formal incident closure with responsible identification and resolution description
- [x] Restriction on editing resolved incidents
- [x] Sequential ID generation resilient to deletions
- [x] JSON-based local persistence with Gson
- [x] Search by ID with Optional
- [x] Continuous menu loop with exit option

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
│               │   └── IncidentService.java
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

---

## 📋 Menu Options

| Option | Description |
|---|---|
| 1 | Register new incident |
| 2 | List all incidents |
| 3 | Search incident by ID |
| 4 | Remove incident |
| 5 | Update incident |
| 6 | Close incident |
| 0 | Exit |

---

## 📐 Architecture

TicketManager follows a layered architecture based on the **Single Responsibility Principle (SRP)**:

- **Model** — Defines what an incident is (data structure and enums)
- **Repository** — Handles data persistence (read/write JSON)
- **Service** — Contains business logic and orchestrates actions
- **App** — Application entry point with interactive menu

### Business Rules

- Every incident is created with status `OPEN` automatically
- Status changes to `IN_PROGRESS` automatically on first update
- Resolved incidents cannot be edited or updated
- Each update generates a timestamped log entry with changed fields
- Incident closure requires responsible identification and resolution description

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

## 📄 License

This project is intended for educational purposes.

---

> Developed by [Kelvin](https://github.com/Kxllvin) · Java Backend Student · 2026
