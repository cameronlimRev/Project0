package user

import scala.io.StdIn._
import java.sql.Connection
import java.sql.DriverManager

class User(name: String, password: String, age: Int, firstDeposit: Double) {
  val thisName = name
  val thisPassword = password
  val thisAge = age
  var thisBalance = firstDeposit

  val url = "jdbc:mysql://localhost:3306/demodatabase"
  val driver = "com.mysql.cj.jdbc.Driver"
  val username = "root"
  val sqlPassword = "fuckSQL@351!"
  var connection: Connection = DriverManager.getConnection(url, username, sqlPassword)

  def getName(): String = {
    return thisName
  }

  def getBalance(): Unit = {
    println(s"Your current balance is $$$thisBalance")
  }

  def deposit(): Unit ={
    println(s"Your balance before the transaction: $$$thisBalance\n")
    print("Please enter the amount you are depositing: $")
    val transactionAmount = readInt()
    thisBalance += transactionAmount
    
    println(s"Your new balance: $$$thisBalance")
  }

  def withdraw(): Unit = {
    println(s"Your balance before the transaction: $$$thisBalance\n")
    print("Please enter the amount you are withdrawing: $")
    val transactionAmount = readInt()
    if ((thisBalance - transactionAmount) > 0){
      thisBalance -= transactionAmount
      println(s"Your new balance: $$$thisBalance")
    } else {
      println("Sorry you do not have enough funds to do this.")
      println(s"Your current balance is $$$thisBalance")
    }
  }
}
