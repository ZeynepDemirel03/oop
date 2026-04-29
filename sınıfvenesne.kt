package oop

class Lamp(){
    var isON: Boolean = false
    fun turnOn(){
        isON=true
    }
    fun turnOff(){
        isON=false
    }
}
fun main(){
    var lamp = Lamp()
    lamp.isON = true
    lamp.turnOff()
    lamp.turnOn()
    var arac = araba()
    arac.model = 2015
    arac.renk = "kırmızı"
    arac.calisma()
    arac.hizlanma()
}
