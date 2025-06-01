# Parkin Smart Parking Android App

A modern Android app frontend for the Parkin Smart Parking Solution, enabling users to view, reserve, and manage parking slots with real-time status updates.  
This app uses Firebase Authentication (Email/Password and Google Sign-In) and is ready for backend API integration.

---

## 🚗 Project Overview

- **Smart Parking:** Camera-monitored slots, each with an RGB lamp (Red = Occupied, Green = Vacant, Purple = Reserved).
- **Bluetooth Mesh:** Each lamp is controlled via a Bluetooth Mesh network, with a central gateway.
- **RESTful API Ready:** The app is designed to connect to a RESTful API for real-time slot management.


## ✨ Features

- **User Authentication:** Email/Password and Google Sign-In via Firebase
- **Sign Up & Password Reset:** Secure registration and password recovery
- **Dashboard:** Color-coded parking slot status (Occupied, Vacant, Reserved)
- **Slot Reservation:** Reserve available slots (UI logic, ready for backend integration)
- **Modern Android UI:** Material Design, RecyclerView, Snackbar feedback


## 🛠️ Getting Started

### Prerequisites

- Android Studio (Giraffe or newer recommended)
- JDK 17 or 21 (JetBrains Runtime preferred)
- [Firebase Console](https://console.firebase.google.com/)
- [Google Cloud Console](https://console.cloud.google.com/) (for Google Sign-In)

### Project Structure
app/
├─ src/main/java/com/example/parkin/
│ ├─ LoginActivity.kt
│ ├─ SignUpActivity.kt
│ ├─ DashboardActivity.kt
│ ├─ ParkingSlotAdapter.kt
│ └─ (models, utils, etc.)
├─ res/layout/
│ ├─ activity_main.xml
│ ├─ activity_signup.xml
│ ├─ activity_dashboard.xml
│ └─ item_parking_slot.xml
├─ res/values/
│ ├─ strings.xml
│ ├─ styles.xml
│ └─ colors.xml
├─ AndroidManifest.xml
└─ google-services.json


---

## 🔑 Firebase & Google Sign-In Setup

1. **Create a Firebase Project:**  
   - Go to [Firebase Console](https://console.firebase.google.com/), create a new project.
   - Add your Android app (use your app's package name).

2. **Add SHA-1 Fingerprint:**  
   - In Android Studio:  
     - Open the Gradle panel > `:app > Tasks > android > signingReport`
     - Copy the `SHA1` for the debug variant.
   - In Firebase Console, add this SHA-1 to your Android app settings.

3. **Enable Authentication Providers:**  
   - In Firebase Console, go to **Authentication > Sign-in method**.
   - Enable **Email/Password** and **Google**.

4. **Download `google-services.json`:**  
   - Download from Firebase Console after adding SHA-1.
   - Place it in your app’s `/app` directory.

5. **Add Web Client ID:**  
   - In Firebase Console, Project Settings > General > Your apps > Web client ID.
   - Add to `res/values/strings.xml`:
     ```
     <string name="default_web_client_id">YOUR-WEB-CLIENT-ID.apps.googleusercontent.com</string>
     ```

---

## 🚀 Build & Run

1. Open the project in Android Studio.
2. Connect your Android device or start an emulator.
3. Click **Run**.

---

## 🧑‍💻 Usage

- **Login** with email/password or Google account.
- **Sign up** for a new account.
- **View the dashboard** to see all parking slots and their statuses.
- **Reserve a slot** (UI logic; ready for API integration).
- **Reset password** via email.

---

## 🔌 Backend/API Integration

- The app is ready for RESTful API integration as per the project specs.
- Replace mock data in the dashboard with real API calls when backend is ready.

---

## 🤝 Contributing

1. Fork this repository.
2. Create a branch: `git checkout -b feature/your-feature`
3. Commit your changes: `git commit -am 'Add new feature'`
4. Push to the branch: `git push origin feature/your-feature`
5. Open a Pull Request.

---

## 📄 License

This project is for the Parkin Lamp Control Challenge.  
For other use, see [LICENSE](LICENSE).

---

## 📚 Project Document (Summary)

- Each parking slot is monitored and has an RGB lamp (Red = Occupied, Green = Vacant, Purple = Reserved).
- Firmware runs on a Bluetooth Mesh-capable MCU.
- RESTful API is hosted on a Bluetooth Mesh gateway (e.g., Raspberry Pi/ESP32).
- App is the user interface for authentication, slot status, and reservation.

---

*Made with ❤️ for the Parkin Smart Parking Solution.*


