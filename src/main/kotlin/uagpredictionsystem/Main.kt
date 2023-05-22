
import uagpredictionsystem.functions.*
import java.io.File
import java.nio.charset.Charset

val excelFile = File("E:\\ISEL\\Projeto\\untitled1\\18052023_UAG_ Planeamento & Controlo_Env.txt")
const val url = "jdbc:postgresql://localhost:5432/postgres"
const val user = "postgres"
const val password = "joaopedro123"
val lines = excelFile.readLines(Charset.forName("ISO-8859-1"))
val headerLocations = lines[2].split(Regex("\\t+")).toMutableList()
val observations = extractObservations(lines)



fun main() {
    headerLocations.removeFirst(); headerLocations.removeLast()
    insertLocationData(url, user, password, headerLocations, observations)
    val levelLocations = extractLevelLocations()
    val levelData = extractLevelData(levelLocations[0], levelLocations[2])
    insertLevelData(levelData)
    val deliveryAndConsumptionData = extractDeliveryData(levelLocations[0],levelLocations[1])
    insertDeliveryData(deliveryAndConsumptionData.first)
    insertConsumption(deliveryAndConsumptionData.second)

}













