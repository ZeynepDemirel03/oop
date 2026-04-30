// --------------------------------
// 1. DATA CLASS NEDİR?
// --------------------------------

// Veri tutmak için kullanılan özel class türüdür
// otomatik olarak bazı fonksiyonları üretir

data class User(val name: String, val age: Int)


// --------------------------------
// 2. OTOMATİK GELENLER
// --------------------------------

// data class şunları otomatik oluşturur:

// toString()
// equals()
// hashCode()
// copy()
// componentN() (destructuring)


// --------------------------------
// 3. toString()
// --------------------------------

fun testToString() {
    val user = User("Ali", 25)

    println(user)
    // çıktı:
    // User(name=Ali, age=25)
}


// --------------------------------
// 4. equals()
// --------------------------------

fun testEquals() {
    val u1 = User("Ali", 25)
    val u2 = User("Ali", 25)

    println(u1 == u2)
    // true → içerik karşılaştırılır
}


// --------------------------------
// 5. copy()
// --------------------------------

fun testCopy() {
    val u1 = User("Ali", 25)

    val u2 = u1.copy(age = 30)
    // ↑ sadece age değişti, diğerleri aynı

    println(u2) // User(name=Ali, age=30)
}


// --------------------------------
// 6. DESTRUCTURING
// --------------------------------

fun testDestructuring() {
    val user = User("Ali", 25)

    val (name, age) = user
    // ↑ component1(), component2() kullanılır

    println(name) // Ali
    println(age)  // 25
}


// --------------------------------
// 7. KURAL (ÇOK ÖNEMLİ)
// --------------------------------

// data class:
// - en az 1 parametre almalı
// - parametreler val veya var olmalı

// data class Empty() ❌ HATA


// --------------------------------
// 8. NEREDE KULLANILIR?
// --------------------------------

// API response
// database model
// UI state
// DTO (Data Transfer Object)


// --------------------------------
// 9. NORMAL CLASS vs DATA CLASS
// --------------------------------

class NormalUser(val name: String, val age: Int)

fun testNormal() {
    val u1 = NormalUser("Ali", 25)
    val u2 = NormalUser("Ali", 25)

    println(u1 == u2)
    // false → referans karşılaştırır
}


// --------------------------------
// 10. KISA ÖZET
// --------------------------------

// data class → veri tutmak için
// otomatik fonksiyonlar sağlar
// equals → içerik bazlı
// copy → kolay kopyalama
