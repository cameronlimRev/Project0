import java.sql.{Connection, DriverManager}
import java.text.SimpleDateFormat
import java.util.Date
import java.util.{Calendar, SimpleTimeZone}

class Transaction(senderID: Int, receiverID: Int, transactionAmount: Double) {
  //Set up SQL Connetion
  val url = "jdbc:mysql://localhost:3306/demodatabase"
  val driver = "com.mysql.cj.jdbc.Driver"
  val username = "root"
  val sqlPassword = "sqlProject0"
  var connection: Connection = DriverManager.getConnection(url, username, sqlPassword)

  def getDate(): String = {
    val transactionDate = (java.time.LocalDate.now).toString
    transactionDate
  }

  def withdrawFromSender(): Unit = {
    try {
      val statement = connection.createStatement
      val rs = statement.executeQuery(s"SELECT balance FROM userdata WHERE userdata.user_id=$senderID")
      rs.next()
      var currentBalance = rs.getDouble("balance")
      currentBalance -= transactionAmount
      val pstmt = connection.prepareStatement(s"UPDATE userdata SET balance = $currentBalance WHERE user_id=$senderID")
      pstmt.executeUpdate()
      println(s"Your new balance is: $currentBalance")
    } catch {
      case e: Exception => e.printStackTrace
    }
  }

  def addToReceiver(): Unit = {
    try {
      val statement = connection.createStatement
      val rs = statement.executeQuery(s"SELECT balance FROM userdata WHERE userdata.user_id=$receiverID")
      rs.next()
      var currentBalance = rs.getDouble("balance")
      currentBalance += transactionAmount
      val pstmt = connection.prepareStatement(s"UPDATE userdata SET balance = $currentBalance WHERE user_id=$receiverID")
      pstmt.executeUpdate()
      val rb = statement.executeQuery(s"SELECT userName FROM userlogins WHERE userlogins.id=$receiverID")
      rb.next()
      val receiverName = rb.getString("userName")
      println(s"$transactionAmount has been added to $receiverName's account.")
    } catch {
      case e: Exception => e.printStackTrace
    }
  }

  def addTransaction(): Unit = {
    val pstmt = connection.prepareStatement("INSERT INTO `transactions`(sender_id,receiver_id,transaction_date, transaction_amount) VALUES (?, ?, ?, ?)")
    pstmt.setInt(1, senderID)
    pstmt.setInt(2, receiverID)
    pstmt.setString(3, getDate())
    pstmt.setDouble(4, transactionAmount)
    pstmt.executeUpdate()
    println("The transaction has been completed.")
  }

  def executeTransaction(): Unit = {
    withdrawFromSender()
    addToReceiver()
    addTransaction()
  }
}
