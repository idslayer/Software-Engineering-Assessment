
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

## 🛡️ License

This project is built for educational purposes and uses open-licensed content from the [Openverse API](https://api.openverse.org/v1/).
