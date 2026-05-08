# 🚀 Smart Email Assistant

## 📌 Overview
AI-powered email reply generation system that integrates with Gmail using a Chrome extension and a Spring Boot backend powered by Gemini API.

---

## 🧠 Projects

### 🔹 1. Smart Email Assistant (AI-Powered Backend Service)

#### 📖 Description
Developed an AI-powered email reply generation service using **Spring Boot** and **Gemini API**.  
The application accepts email content and tone as input and generates professional email responses 
using generative AI. Implemented REST APIs, prompt engineering, response parsing, and robust exception handling. 
Integrated WebClient for external API communication and ensured secure API key management using environment variables.

#### ⚙️ Key Features
- REST API for email generation  
- Dynamic prompt engineering  
- AI response parsing using Jackson  
- Robust exception handling  
- External API integration using WebClient  
- Secure API key management using environment variables  

---

### 🔹 2. Gmail AI Reply Chrome Extension

#### 📖 Description
Built a Chrome extension that integrates directly with **Gmail UI** to generate AI-based email replies.  
The extension injects a custom **"AI Reply"** button into the compose window, captures email content, and communicates with a Spring Boot backend service. The backend processes the request using Gemini API and returns a generated response, 
which is automatically inserted into the Gmail compose box.

#### ⚙️ Key Features
- Gmail UI integration using content scripts  
- Dynamic button injection in compose window  
- Captures email content in real-time  
- Calls Spring Boot backend API  
- Automatically inserts generated reply into compose box  

---

## 🔄 How It Works

1. User opens Gmail compose window  
2. Extension injects **AI Reply** button  
3. User clicks the button  
4. Email content is captured  
5. Request sent to Spring Boot backend  
6. Backend calls Gemini API  
7. AI generates response  
8. Response is returned and inserted into Gmail  

---

## 🛠️ Tech Stack

### Backend
- Java  
- Spring Boot  
- WebClient  
- Gemini API  
- Jackson  

### Extension
- JavaScript  
- Chrome Extension (Manifest V3)  
- Gmail DOM manipulation  

---

## 🔒 Security
- API keys managed using environment variables  
- Sensitive data not exposed in frontend  

---

## 👨‍💻 Author
**Niranjana Charty**
