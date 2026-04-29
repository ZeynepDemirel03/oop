// --------------------------------
// 1. PRIMARY CONSTRUCTOR
// --------------------------------

class User(val name: String, val age: Int)
    // ↑ Primary constructor
    // name ve age dışarıdan alınır
    // val olduğu için property olarak saklanır (immutable)

fun testPrimary() {
    val user = User("Ali", 25)
    // ↑ nesne oluşturulurken constructor çalışır
}


// --------------------------------
// 2. INIT BLOĞU
// --------------------------------

class UserWithInit(val name: String, val age: Int) {

    init {
        println("Kullanıcı oluşturuldu: $name")
        // ↑ constructor çağrıldığında otomatik çalışır
    }
}

fun testInit() {
    val user = UserWithInit("Ali", 25)
    // ↑ önce constructor parametreleri alınır
    // ↑ sonra init bloğu çalışır
}


// --------------------------------
// 3. CONSTRUCTOR + INIT KULLANIMI
// --------------------------------

class UserCheck(val name: String, val age: Int) {

    init {
        if (age < 0) {
            throw IllegalArgumentException("Yaş negatif olamaz")
            // ↑ init genelde validation (kontrol) için kullanılır
        }
    }
}


// --------------------------------
// 4. SECONDARY CONSTRUCTOR
// --------------------------------

class UserSecondary {

    var name: String
    var age: Int

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
        // ↑ manuel atama yapılır
    }
}


// --------------------------------
// 5. MULTIPLE CONSTRUCTOR
// --------------------------------

class UserMulti {

    var name: String
    var age: Int

    constructor(name: String) {
        this.name = name
        this.age = 0
        // ↑ age verilmezse default 0
    }

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
        // ↑ hem name hem age verilebilir
    }
}


// --------------------------------
// 6. MULTIPLE INIT BLOKLARI
// --------------------------------

class MultiInit {

    init {
        println("1. init çalıştı")
    }

    init {
        println("2. init çalıştı")
    }
}

fun testMultiInit() {
    val obj = MultiInit()
    // çıktı:
    // 1. init çalıştı
    // 2. init çalıştı
}


// --------------------------------
// 7. ÇALIŞMA SIRASI (ÇOK ÖNEMLİ)
// --------------------------------

class OrderExample(val name: String) {

    init {
        println("init: $name")
    }
}

fun testOrder() {
    val obj = OrderExample("Ali")
    // sıra:
    // 1. constructor parametreleri alınır
    // 2. init blokları çalışır
}


// --------------------------------
// 8. GERÇEK HAYAT ÖRNEĞİ
// --------------------------------

class BankAccount(val owner: String, var balance: Int) {

    init {
        require(balance >= 0) {
            "Bakiye negatif olamaz"
        }
        // ↑ require → şart sağlanmazsa exception fırlatır
    }

    fun deposit(amount: Int) {
        balance += amount
    }
}


// --------------------------------
// 9. KISA ÖZET
// --------------------------------

// constructor → veri alır
// init → veriyle işlem yapar

// birlikte çalışırlar:
// new object → constructor → init → hazır
