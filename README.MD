# Gudang Kopi Pak Parman - Inventory Management System

A Java Swing desktop application designed for managing coffee warehouse inventory. The system features a modern FlatLaf user interface with vector SVG navigation icons for recording incoming and outgoing inventory and generating reports.

---

## Technical Stack

* **Language:** Java (JDK 24+)
* **GUI Framework:** Java Swing
* **UI Theme & Utilities:** [FlatLaf](https://www.formdev.com/flatlaf/) and `flatlaf-extras`
* **Database Connection:** MySQL / JDBC (`Koneksi.java`)
* **Build System:** Apache Maven

---

## Directory Structure

```text
GudangKopi/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/mycompany/gudangkopi/
│       │        ├── GudangKopi.java
│       │        ├── config/
│       │        │   └── Koneksi.java
│       │        └── view/
│       │            ├── MainFrame.java
│       │            ├── dashboard.java
│       │            ├── barangMasuk.java
│       │            ├── barangKeluar.java
│       │            └── laporan.java
│       └── resources/
│           └── assets/
│               └── SideBar/
│                   ├── Logo.png
│                   ├── Dashboard.svg
│                   ├── BarangMasuk.svg
│                   ├── BarangKeluar.svg
│                   ├── Laporan.svg
│                   └── Keluar.svg
├── pom.xml
└── README.md

```

## Dependencies (pom.xml)
Ensure the following dependencies are present in your pom.xml:

---
    <!-- FlatLaf Core and Extras -->
    <dependency>
        <groupId>com.formdev</groupId>
        <artifactId>flatlaf</artifactId>
        <version>3.5.2</version>
    </dependency>
    <dependency>
        <groupId>com.formdev</groupId>
        <artifactId>flatlaf-extras</artifactId>
        <version>3.5.2</version>
    </dependency>

    <!-- JSVG Renderer -->
    <dependency>
        <groupId>com.github.weisj</groupId>
        <artifactId>jsvg</artifactId>
        <version>1.6.0</version>
    </dependency>
---

# Getting Started
* Prerequisites
* JDK 24 or higher
* Apache Maven

## Installation & Build
1. Clone the repository: 

````
git clone https://github.com/mulqi/GudangKopi.git

cd GudangKopi
````

2. Clean and compile the resources:

````
mvn clean compile
````

3. Run the application:

````
mvn exec:java -Dexec.mainClass="com.mycompany.gudangkopi.GudangKopi"
````
## Core Modules
* Dashboard: summary of current warehouse operations.

* Incoming Goods (Barang Masuk): Module to record new stock items entering the warehouse.

* Outgoing Goods (Barang Keluar): Module to track items dispatched or sold.

* Reports (Laporan): Recaps and transaction history overview.



