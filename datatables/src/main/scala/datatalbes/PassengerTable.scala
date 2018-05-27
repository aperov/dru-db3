package datatalbes

import slick.jdbc.H2Profile.api._

class PassengerTable(tag: Tag) extends Table[model.Passenger](tag, "Passenger") {
  val passengerId = column[Int]("ID_psg", O.PrimaryKey)
  val name = column[String]("name")



  def * = (passengerId, name).mapTo[model.Passenger]
}

object PassengerTable {
  val table = TableQuery[PassengerTable]
}