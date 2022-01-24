package user

import scala.io.StdIn.*
import java.sql.Connection
import java.sql.DriverManager
import java.io._

class User(name: String) {
  val thisName = name
  var thisBalance = 5000

  val url = "jdbc:mysql://localhost:3306/demodatabase"
  val driver = "com.mysql.cj.jdbc.Driver"
  val username = "root"
  val sqlPassword = "sqlProject0"
  var connection: Connection = DriverManager.getConnection(url, username, sqlPassword)

  def getName(): String = {
    return thisName
  }

  def getBalance(currentUser: String, currentPin: Int): Unit = {
    try {
      val statement = connection.createStatement
      val rs = statement.executeQuery(s"SELECT balance FROM userdata WHERE userdata.user_id=(SELECT id from userlogins WHERE userName='$currentUser' AND userPin='$currentPin')")
      rs.next()
      var currentBalance = rs.getDouble("balance")
      println(f"Your current Balance is: $$$currentBalance%1.2f")
    } catch {
        case e: Exception => e.printStackTrace
    }
  }

  def deposit(currentUser: String, currentPin: Int): Unit ={
    try {
      val statement = connection.createStatement
      val rs = statement.executeQuery(s"SELECT balance FROM userdata WHERE userdata.user_id=(SELECT id from userlogins WHERE userName='$currentUser' AND userPin='$currentPin')")
      rs.next()
      var currentBalance = rs.getDouble("balance")
      println(s"Your balance before the transaction: $$$currentBalance\n")
      print("Please enter the amount you are depositing: $")
      val transactionAmount = readDouble()
      currentBalance += transactionAmount
      println(f"Your new balance: $$$currentBalance%1.2f")
      val pstmt = connection.prepareStatement(s"UPDATE userdata SET balance = $currentBalance WHERE user_id=(SELECT id from userlogins WHERE userName='$currentUser' AND userPin='$currentPin')")
      pstmt.executeUpdate()
    } catch {
        case e: Exception => e.printStackTrace
    }
  }

  def withdraw(currentUser: String, currentPin: Int): Unit = {
    try {
      val statement = connection.createStatement
      val rs = statement.executeQuery(s"SELECT balance FROM userdata WHERE userdata.user_id=(SELECT id from userlogins WHERE userName='$currentUser' AND userPin='$currentPin')")
      rs.next()
      var currentBalance = rs.getDouble("balance")
      println(s"Your balance before the transaction: $$$currentBalance\n")
      print("Please enter the amount you are withdrawing: $")
      val transactionAmount = readDouble()
      currentBalance -= transactionAmount
      println(f"Your new balance: $$$currentBalance%1.2f")
      val pstmt = connection.prepareStatement(s"UPDATE userdata SET balance = $currentBalance WHERE user_id=(SELECT id from userlogins WHERE userName='$currentUser' AND userPin='$currentPin')")
      pstmt.executeUpdate()
    } catch {
        case e: Exception => e.printStackTrace
    }
  }

  def printBalance(currentUser: String, currentPin: Int): Unit = {
    try {
      val statement = connection.createStatement
      val rs = statement.executeQuery(s"SELECT balance FROM userdata WHERE userdata.user_id=(SELECT id from userlogins WHERE userName='$currentUser' AND userPin='$currentPin')")
      rs.next()
      var currentBalance = rs.getDouble("balance")
      val file = new File(s"src/userBalances/'$currentUser'_balance.txt")
      val bw = new BufferedWriter(new FileWriter(file))
      bw.write(f"$currentUser your balance is: $$$currentBalance%1.2f.")
      bw.close()
      println("Your balance has been saved to src/userBalances")
    } catch {
      case e: Exception => e.printStackTrace
    }
  }
  connection.close()
}
