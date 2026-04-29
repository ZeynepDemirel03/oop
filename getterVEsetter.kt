// ===============================
// GETTER & SETTER NEDİR?
// ===============================


// --------------------------------
// 1. BASİT PROPERTY (DEFAULT)
// --------------------------------

class User {

    var name: String = "Ali"
    // ↑ Kotlin otomatik olarak:
    // getter → name'i okumak için
    // setter → name'i değiştirmek için oluşturur
}

fun testDefault() {
    val user = User()

    println(user.name)  // getter çalışır
    user.name = "Veli"  // setter çalışır
}


// --------------------------------
// 2. GETTER NEDİR?
// --------------------------------

class GetterExample {

    val name: String = "Ali"

    val upperName: String
        get() = name.uppercase()
        // ↑ getter override edildi
        // her çağrıldığında büyük harf döner
}

fun testGetter() {
    val obj = GetterExample()

    println(obj.upperName)
    // ↑ "ALI" döner (hesaplanmış değer)
}


// --------------------------------
// 3. SETTER NEDİR?
// --------------------------------

class SetterExample {

    var age: Int = 0
        set(value) {
            if (value < 0) {
                println("Negatif yaş olamaz")
            } else {
                field = value
                // ↑ field → gerçek değişkeni temsil eder
            }
        }
}

fun testSetter() {
    val obj = SetterExample()

    obj.age = 25   // setter çalışır → kabul edilir
    obj.age = -5   // setter çalışır → reddedilir
}


// --------------------------------
// 4. GETTER + SETTER BİRLİKTE
// --------------------------------

class FullExample {

    var number: Int = 0
        get() {
            println("Getter çalıştı")
            return field
        }
        set(value) {
            println("Setter çalıştı")
            field = value
        }
}

fun testFull() {
    val obj = FullExample()

    obj.number = 10  // setter çalışır
    println(obj.number) // getter çalışır
}


// --------------------------------
// 5. PRIVATE SETTER (çok önemli)
// --------------------------------

class PrivateSetterExample {

    var count: Int = 0
        private set
        // ↑ dışarıdan değiştirilemez
        // sadece class içinden set edilebilir

    fun increase() {
        count++
    }
}

fun testPrivateSetter() {
    val obj = PrivateSetterExample()

    // obj.count = 5 ❌ HATA (setter private)
    println(obj.count) // ✅ getter public

    obj.increase() // ✅ içeriden değiştirildi
}


// --------------------------------
// 6. BACKING FIELD (field)
// --------------------------------

class FieldExample {

    var name: String = "Ali"
        set(value) {
            field = value.trim()
            // ↑ field → gerçek değeri temsil eder
            // setter içinde kullanılır
        }
}


// --------------------------------
// 7. KISA ÖZET
// --------------------------------

// getter → değeri okurken çalışır
// setter → değeri değiştirirken çalışır

// Kotlin otomatik üretir
// ama istersek override ederiz

// field → gerçek değişken (arka planda)
