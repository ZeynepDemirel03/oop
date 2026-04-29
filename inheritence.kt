// --------------------------------
// 1. INHERITANCE NEDİR?
// --------------------------------

// Bir class'ın başka bir class'ın özelliklerini almasıdır

open class Animal {
    // ↑ open: bu class'tan miras alınabileceğini belirtir

    fun eat() {
        println("Yemek yiyor")
    }
}


// --------------------------------
// 2. BASİT KALITIM
// --------------------------------

class Dog : Animal() {
    // ↑ Dog, Animal'dan miras alır

    fun bark() {
        println("Havlıyor")
    }
}

fun testBasicInheritance() {
    val dog = Dog()

    dog.eat()   // ✅ parent'tan geldi
    dog.bark()  // ✅ kendi fonksiyonu
}


// --------------------------------
// 3. NEDEN open?
// --------------------------------

// Kotlin'de class'lar default olarak FINAL'dir
// yani miras alınamaz

// open yazmazsan hata alırsın

// class Animal {} ❌ miras alınamaz
// open class Animal {} ✅ miras alınabilir


// --------------------------------
// 4. METHOD OVERRIDE
// --------------------------------

open class Animal2 {

    open fun makeSound() {
        println("Hayvan ses çıkarır")
    }
}

class Cat : Animal2() {

    override fun makeSound() {
        println("Miyav")
        // ↑ parent fonksiyon override edildi
    }
}

fun testOverride() {
    val cat = Cat()
    cat.makeSound() // Miyav
}


// --------------------------------
// 5. SUPER KULLANIMI
// --------------------------------

open class Animal3 {

    open fun makeSound() {
        println("Genel ses")
    }
}

class Bird : Animal3() {

    override fun makeSound() {
        super.makeSound() // parent fonksiyon çağrılır
        println("Cik cik")
    }
}


// --------------------------------
// 6. CONSTRUCTOR + INHERITANCE
// --------------------------------

open class Animal4(val name: String)

class Dog2(name: String) : Animal4(name)
// ↑ parent constructor'a parametre gönderilir


// --------------------------------
// 7. INIT + INHERITANCE
// --------------------------------

open class Animal5(val name: String) {

    init {
        println("Animal init: $name")
    }
}

class Dog3(name: String) : Animal5(name) {

    init {
        println("Dog init: $name")
    }
}

fun testInitOrder() {
    val dog = Dog3("Karabas")
    // çıktı:
    // Animal init: Karabas
    // Dog init: Karabas
    // ↑ önce parent sonra child çalışır
}


// --------------------------------
// 8. ABSTRACT CLASS
// --------------------------------

abstract class Animal6 {

    abstract fun makeSound()
    // ↑ gövdesi yok, child yazmak zorunda

    fun eat() {
        println("Yemek yiyor")
    }
}

class Dog4 : Animal6() {

    override fun makeSound() {
        println("Hav hav")
    }
}


// --------------------------------
// 9. FINAL (override engelleme)
// --------------------------------

open class Animal7 {

    open fun run() {}

    final fun sleep() {}
    // ↑ override edilemez
}

class Dog5 : Animal7() {

    override fun run() {} // ✅

    // override fun sleep() {} ❌ HATA
}


// --------------------------------
// 10. KISA ÖZET
// --------------------------------

// open → miras alınabilir
// override → ezme (değiştirme)
// super → parent çağırma
// init sırası → önce parent sonra child
// abstract → zorunlu implement
// final → override engeller
