// --------------------------------
// 1. ABSTRACTION NEDİR?
// --------------------------------

// Gereksiz detayları gizleyip,
// sadece gerekli olanı göstermektir

// "Nasıl çalışıyor?" değil
// "Ne yapıyor?" önemli


// --------------------------------
// 2. ABSTRACT CLASS
// --------------------------------

abstract class Animal {
    // ↑ abstract class: nesne oluşturulamaz

    abstract fun makeSound()
    // ↑ abstract fonksiyon: gövdesi yok
    // child class yazmak zorunda

    fun eat() {
        println("Yemek yiyor")
        // ↑ normal fonksiyon (gövdesi var)
    }
}


// --------------------------------
// 3. IMPLEMENTATION (UYGULAMA)
// --------------------------------

class Dog : Animal() {

    override fun makeSound() {
        println("Hav hav")
        // ↑ abstract fonksiyon burada dolduruldu
    }
}

class Cat : Animal() {

    override fun makeSound() {
        println("Miyav")
    }
}

fun testAbstraction() {
    val dog = Dog()
    val cat = Cat()

    dog.makeSound() // Hav hav
    cat.makeSound() // Miyav
}


// --------------------------------
// 4. NEDEN ABSTRACTION?
// --------------------------------

// Ortak bir yapı oluşturur
// tekrar eden kodu azaltır

// Animal → tüm hayvanlar için base yapı


// --------------------------------
// 5. REAL LIFE MANTIK
// --------------------------------

// Remote kontrol örneği:

abstract class Remote {

    abstract fun turnOn()
    abstract fun turnOff()

    fun info() {
        println("Remote hazır")
    }
}

class TVRemote : Remote() {

    override fun turnOn() {
        println("TV açıldı")
    }

    override fun turnOff() {
        println("TV kapandı")
    }
}


// --------------------------------
// 6. INTERFACE (ABSTRACTION'IN DİĞER YOLU)
// --------------------------------

interface Vehicle {

    fun start()
    // default olarak abstract

    fun stop() {
        println("Durdu")
        // default implementasyon olabilir
    }
}

class Car : Vehicle {

    override fun start() {
        println("Araba çalıştı")
    }
}


// --------------------------------
// 7. ABSTRACT vs INTERFACE
// --------------------------------

// abstract class:
// - constructor olabilir
// - state (değişken) tutabilir
// - tek inheritance

// interface:
// - birden fazla implement edilir
// - constructor yok
// - genelde davranış tanımlar


// --------------------------------
// 8. POLYMORPHISM İLE BİRLİKTE
// --------------------------------

fun makeAnimalSound(animal: Animal) {
    animal.makeSound()
    // ↑ hangi class gelirse ona göre çalışır
}


// --------------------------------
// 9. KULLANILAMAYAN DURUM
// --------------------------------

fun testError() {
    // val animal = Animal() ❌ HATA
    // abstract class'tan nesne oluşturulamaz
}


// --------------------------------
// 10. KISA ÖZET
// --------------------------------

// abstraction → detayları gizler
// abstract class → yarım class
// abstract method → zorunlu override
// interface → davranış tanımı
