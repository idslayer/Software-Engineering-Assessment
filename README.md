
# 📸 Open Media Search Application

**Student Name**: Truong Minh Phuong  
**Student ID**: 29697148
**Module**: Software Engineering (CMP9134)

A full-stack web application that allows users to search for openly licensed media (images and audio) using the Openverse API.

---

## 🛠 Tech Stack

- **Frontend**: React + Vite + Nginx
- **Backend**: Java Spring Boot + Java 11
- **Authentication**: JWT-based (Spring Security)
- **Deployment**: Azure Container Apps
- **CI/CD**: GitHub Actions
- **Containerisation**: Docker

---

## 🚀 Features

- Search for images/audio via Openverse API
- User registration and JWT login
- Save & retrieve recent searches (in-session)
- Responsive UI for mobile and desktop
- Containerised deployment with Docker
- Deployed frontend and backend on Azure

---

## 📂 Project Structure

```
/femediasearch     # React + Vite application
/bemediasearch        # Java Spring Boot backend
```

---

## 🧑‍💻 Quick Start (Run with Docker) -- Need to install docker first

### 1. Clone the repository

```bash
git clone https://github.com/idslayer/Software-Engineering-Assessment

```

### 2. Run Frontend

```bash
cd femediasearch 
docker build -t openmedia-fe .
docker run -p 3000:80 openmedia-fe
```

### ⚠️ IMPORTANT

Make sure to **update the API base URL** in your React frontend code to point to your backend, or remain to connect Azure-hosted backend.  
For example, if using a `variable.jsx` file:

```js
const config = {
     url: 'localhost:8080',
};
```

This ensures your frontend communicates correctly with the backend.

---

### 3. Run Backend

```bash
cd bemediasearch
docker -t openmedia-be .
docker run -p 8080:8080 openmedia-be
```


## 🌐 Live Demo

- **Frontend**: https://femedia.wittymushroom-335f7e4f.uksouth.azurecontainerapps.io
- **Backend API**: https://bemedia.wittymushroom-335f7e4f.uksouth.azurecontainerapps.io

---

## 🧪 Testing

- Backend tests: `./mvnw test` (run in bemediasearch folder)
- Frontend: Manual testing via browser 

---

## 📦 Deployment

- CI/CD configured using GitHub Actions
- Automatically builds & deploys Docker images to Azure Container Apps
- Secure and scalable cloud deployment

---
## 🧑‍💻 Alternative Run (Without Docker)

For users who prefer not to use Docker, the frontend and backend can be run directly on your local machine:

### 🔧 Prerequisites

- **Frontend**: Node.js 18+
- **Backend**: Java 11, Maven (or use included `./mvnw` wrapper)

## 🔗 Useful Links

- [Download Node.js 18 for Windows](https://nodejs.org/dist/v18.18.2/node-v18.18.2-x64.msi)
- [Download Java 11 (Temurin) for Windows](https://adoptium.net/en-GB/temurin/releases/?version=11)

Ensure both tools are added to your system's PATH after installation for terminal access.
### 1. Run Backend (Spring Boot)

```bash
cd bemediasearch 
./mvnw spring-boot:run
```


This will start the backend at: `http://localhost:8080`

### 2. Run Frontend (React + Vite)

```bash
cd femediasearch 
npm install
npm run dev
```

This will start the frontend at: `http://localhost:5173`

> 📌 Make sure to update the frontend API base URL to match your local backend (`http://localhost:8080`) in your config file.

---
## 🛡️ License

This project is built for educational purposes and uses open-licensed content from the [Openverse API](https://api.openverse.org/v1/).
