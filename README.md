# 🎬 cineperu-automation-services

## 📌 Descripción
Proyecto de **automatización de pruebas** para los servicios de **CinePerú**, desarrollado con:
- **Java**
- **Serenity BDD**
- **Cucumber**
- **RestAssured**

Su objetivo es validar el correcto funcionamiento de los endpoints, utilizando datos dinámicos como tokens, nombres y géneros de películas.

---

## 📂 Estructura del Proyecto

```text
cineperu-automation-services/
├── .gitignore
├── pom.xml
├── src/
│   ├── main/java/
│   └── test/
│       ├── java/
│       │   ├── question/      
│       │   ├── runner/
│       │   ├── stepdefinition/  
│       │   ├── task/    
│       │   └── util/     
│       └── resources/
│           ├── features/
│           ├── request/  
│           └── serenity.conf
└── README.md
```

## ⚙️ Requisitos Previos
- **Java JDK 11+**
- **Apache Maven**

---

## ▶️ Ejecución de las Pruebas

**Ejecutar por terminal:**
```bash
mvn clean verify -Denvironment=prd -Dcucumber.filter.tags=@REGRESION
```

**Ejecutar por IDE:**
```bash
clean verify -Denvironment=prd -Dcucumber.filter.tags=@REGRESION
```
<img width="938" height="719" alt="image" src="https://github.com/user-attachments/assets/38f1d904-c274-479c-883d-19f935c5468d" />

