// 1. تعريف الإضافات (Plugins) المطلوبة
plugins {
    id("com.android.application") version "8.2.2" apply false
    id("com.android.library") version "8.1.1" apply false
    id("com.google.gms.google-services") version "4.3.15" apply false
}

// 2. مستودعات التحميل
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // تأكد من استخدام الأقواس () وعلامات التنصيص المزدوجة ""
        classpath("com.google.gms:google-services:4.3.15")
    }
}