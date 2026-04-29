package oop
// public    → her yerden erişilir
// private   → sadece bulunduğu yerden erişilir
// protected → class + subclass erişir
// internal  → aynı modül erişir

// ===============================
// 1. PUBLIC (varsayılan)
// ===============================

// public yazmasan da default olarak public olur
class PublicExample {

    val name = "Ahmet"   // public (her yerden erişilebilir)

    fun printName() {
        println(name)    // aynı sınıf içinde erişim
    }
}

// başka bir yerden erişim
fun testPublic() {
    val obj = PublicExample()
    println(obj.name)      // ✅ erişilebilir
    obj.printName()        // ✅ erişilebilir
}

// ===============================
// 2. PRIVATE
// ===============================

class PrivateExample {

    private val secret = "1234" // sadece bu sınıf içinde erişilebilir

    fun showSecret() {
        println(secret) // ✅ aynı sınıf içinde erişim var
    }
}

fun testPrivate() {
    val obj = PrivateExample()

    // println(obj.secret) ❌ HATA! dışarıdan erişilemez

    obj.showSecret() // ✅ public fonksiyon üzerinden erişiyoruz
}

// ===============================
// 3. PROTECTED (inheritance için)
// ===============================

// open: bu class'tan miras alınabileceğini belirtir
open class Animal {

    protected fun makeSound() {
        println("Hayvan ses çıkardı")
    }
}

class Dog : Animal() {

    fun bark() {
        makeSound() // ✅ protected olduğu için alt sınıfta erişilebilir
    }
}

fun testProtected() {
    val dog = Dog()
    dog.bark() // ✅

    // dog.makeSound() ❌ HATA! dışarıdan erişilemez
}
// ===============================
// 4. INTERNAL
// ===============================

// internal: aynı modül (project/module) içinde erişilebilir
internal class InternalExample {

    fun doSomething() {
        println("Internal çalıştı")
    }
}

fun testInternal() {
    val obj = InternalExample()
    obj.doSomething() // ✅ aynı modül içinde erişilir
}
open class BankAccount {

    public var owner = "Ali"
    // herkes erişebilir

    private var balance = 1000
    // sadece bu class içinde erişilir

    protected fun calculateInterest() {
        println("Faiz hesaplandı")
    }
    // sadece subclass erişebilir

    internal fun logTransaction() {
        println("Log atıldı")
    }
    // aynı modül içinde erişilir

    fun deposit(amount: Int) {
        balance += amount
        println("Yeni bakiye: $balance")
    }
}

// subclass
class PremiumAccount : BankAccount() {

    fun showFeatures() {
        println(owner) // ✅ public erişilir

        // println(balance) ❌ private → erişilemez

        calculateInterest() // ✅ protected → erişilir

        logTransaction() // ✅ internal → aynı modül
    }
}

fun testAll() {
    val acc = PremiumAccount()

    println(acc.owner) // ✅ public

    // println(acc.balance) ❌ private

    // acc.calculateInterest() ❌ protected

    acc.logTransaction() // ✅ internal

    acc.deposit(500) // ✅ public
}
