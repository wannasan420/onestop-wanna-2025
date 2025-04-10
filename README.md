# **Console-Based Calculator (Maven Project)**

## **📌 Project Overview**
This is a **console-based calculator application** built with **Java** and **Maven**. It demonstrates **OOP principles** such as **encapsulation** and **abstraction** while providing a user-friendly interface for performing basic arithmetic operations.

## **📂 Project Structure**
```
console-app-calculator/
│── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com.wanna.calculator/
│   │   │   │   ├── CalculatorApplication.java
│   │   │   │   ├── feature/
│   │   │   │   │   ├── FeatureForAdding.java
│   │   │   │   │   ├── FeatureForSubstraction.java
│   ├── test/
│   ├── resources/
│── pom.xml
│── README.md
```

## **🛠 Features**
✅ **Basic Arithmetic Operations**: Addition, Subtraction, etc.  
✅ **Modular Codebase**: Follows OOP principles.  
✅ **User Input Handling**: Uses Java Scanner for interaction.  
✅ **Maven Project Structure**: Easy dependency management.  

## **📌 Requirements**
- **Java JDK 21+**
- **Maven 3.8+**
- **Git** (For version control)
- **Eclipse / IntelliJ IDEA / VS Code (Optional)**

## **🚀 Installation & Setup**
### **1️⃣ Clone the Repository**
```sh
git clone git@github.com:wannasan420/new-maven-project.git
cd new-maven-project
```

### **2️⃣ Build the Project**
```sh
mvn clean install
```

### **3️⃣ Run the Application**
```sh
mvn exec:java -Dexec.mainClass="com.wanna.calculator.CalculatorApplication"
```

## **📌 Usage**
1️⃣ Run the application and follow the instructions on the console.  
2️⃣ Enter the operation number (e.g., `1` for addition, `2` for subtraction).  
3️⃣ Provide the required inputs and get the result instantly.  

## **📌 Troubleshooting**
- If **Eclipse/Maven doesn't recognize dependencies**, run:
  ```sh
  mvn clean install -U
  ```
- If **Git push fails**, check your SSH setup:
  ```sh
  ssh -T git@github.com
  ```

## **🤝 Contributing**
### **1️⃣ Fork the Repository**
Click the **Fork** button on GitHub to create your own copy.

### **2️⃣ Create a Feature Branch**
```sh
git checkout -b feature-name
```

### **3️⃣ Commit Your Changes**
```sh
git add .
git commit -m "Added a new feature"
```

### **4️⃣ Push & Create a Pull Request**
```sh
git push origin feature-name
```
Then, create a **Pull Request** on GitHub.

## **📜 License**
This project is licensed under the **MIT License**.

---
### 🎯 **Happy Coding!** 🚀

