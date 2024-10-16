package com.example.tutoriels

/*class SmartDevice {

    val name = "Android TV"
    val category = "Entertainment"
    val deviceStatus = "Online"

    fun TurnOn() {
        println("Smart device is turned on")
    }

    fun TurnOf() {
        println("Smart device is turned off.")
    }

}*/

/**      Constructor      **/

/*class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    var speakerVolum = 2
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }
    var channelNumber = 1
        set(value) {
            if (value in 0..200)
                field = value
        }

    fun increaseSpeakerVolume() {
    speakerVolum++
    println("Speaker volume increased to $speakerVolum.")

    }

    fun nextChannel() {
    channelNumber++
    println("Channel number increased to $channelNumber.")
    }
}

fun main() {
    val smartTvDevice = SmartDevice()

    println("Devive name is : ${smartTvDevice.name}")

    smartTvDevice.TurnOn()
    smartTvDevice.TurnOf()
}*/


/**     Héritage    **/


/*import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty



open class SmartDevice(val name: String , val category: String) {
    var deviceStatus = "Oneline"

    open fun turnOn() {
        deviceStatus = "Online"
        println("$name is turned on.")
    }

    open fun turnOff() {
        deviceStatus = "Offline"
        println("$name is turned off.")
    }

}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

        override val deviceType = "Smart TV"

        private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

        /*var brightnessLevel = 0
            set(value) {
                if (value in 0..100) {
                    field = value
                }
            }*/

        fun increaseBrightness() {
            brightnessLevel++
            println("Brightness increased to $brightnessLevel.")
        }

        override fun turnOn() {
            deviceStatus = "on"
            brightnessLevel = 2
            println("$name turned on. The brightness level is $brightnessLevel.")
        }

        override fun turnOff() {
            deviceStatus = "off"
            brightnessLevel = 0
            println("Smart Light turned off")
        }

}

class SmartTvDevice(deviceName: String , deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV"

    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 1, maxValue = 200)



        /*var speakerVolume = 2
            set(value) {
                if (value in 0..100) {
                    field = value
                }
            }
        var channelNumber = 1
            set(value) {
                if (value in 0..200) {
                    field = value
                }
            }*/

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }

    override fun turnOn() {
        deviceStatus = "on"
        println("$name is turned on. Speaker volume is set to $speakerVolume and channel number is" +
                "set to $channelNumber"
        )
    }

    override fun turnOff() {
        deviceStatus = "off"
        println("$name turned off")
    }
}

class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {
    fun turnOnTv() {
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
        smartTvDevice.turnOff()
    }

    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }

    fun turnOnLight() {
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
        smartLightDevice.turnOff()
    }

    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }

    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}


class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}


fun main() {
    var smartDevice: SmartDevice = SmartTvDevice("Android TV" , "Entertainment")
    smartDevice.turnOn()

    smartDevice = SmartLightDevice("Google Light" , "Utility" )
    smartDevice.turnOn()
}*/




import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice(val name: String, val category: String) {

    var deviceStatus = "online"
        protected set

    open val deviceType = "unknown"

    open fun turnOn() {
        deviceStatus = "on"
    }

    open fun turnOff() {
        deviceStatus = "off"
    }
}

class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV"

    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }

    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                    "set to $channelNumber."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light"

    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}

class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {

    var deviceTurnOnCount = 0
        private set

    fun turnOnTv() {
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
        deviceTurnOnCount--
        smartTvDevice.turnOff()
    }

    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }

    fun turnOnLight() {
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
        deviceTurnOnCount--
        smartLightDevice.turnOff()
    }

    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }

    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}

class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}

fun main() {
    var smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment")
    smartDevice.turnOn()

    smartDevice = SmartLightDevice("Google Light", "Utility")
    smartDevice.turnOn()
}



