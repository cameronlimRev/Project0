import scala.io.StdIn._
import user.User
import java.sql.Connection
import java.sql.DriverManager

object ATM{
    //SQL SETUP AND EXAMPLE
    val url = "jdbc:mysql://localhost:3306/demodatabase"
    val driver = "com.mysql.cj.jdbc.Driver"
    val username = "root"
    val password = "fuckSQL@351!"
    var connection: Connection = _

    try {
        Class.forName(driver)
        connection = DriverManager.getConnection(url, username, password)
        val statement = connection.createStatement
        val rs = statement.executeQuery("SELECT userName,userPin from userlogins")
        while (rs.next) {
            val host = rs.getString("userName")
            val user = rs.getString("userPin")
            println("host = %s, user = %s".format(host,user))
        }
    } catch {
        case e: Exception => e.printStackTrace
    }
    connection.close









    val testingName = "Cameron"
    var user1 = User("Cameron", "Admin", 23, 5000)

    def openLogin(): Unit = {
        println(
            """  _____________________________________
              |//       Welcome to Revature Banking       \\
              ||| If you need to register for a new       ||
              ||| account please enter "New" below.       ||
              ||| Please enter your login information:    ||
              |""".stripMargin)
        var getUsername = readLine("Username: ")
        if (getUsername.equals("New")){
            createAccount()
        }
    }

    def createAccount(): Unit = {
        println(
            """  _________________________________________
              |//       Let's create an account!          \\
              |=============================================
              |""".stripMargin)
        var requestedUsername = readLine("Please enter your desired username:     ")
        println(" You will need a four digit PIN.    ")
        println(" Please enter your desired PIN:     ")
        var requestedPin = readInt()

        try {
            Class.forName(driver)
            connection = DriverManager.getConnection(url, username, password)
            val statement = connection.createStatement
            val pstmt = connection.prepareStatement("INSERT INTO `userlogins`(userName,userPin) VALUES (?, ?)")
            pstmt.setString(1, requestedUsername)
            pstmt.setInt(2, requestedPin)
            pstmt.executeUpdate()
            println("Your new account has been created!")
        } catch {
            case e: Exception => e.printStackTrace
        }
        connection.close
    }

    def openMenu(): Int = {
        println(
            s"""  _______________________________________
              |//   Welcome to Revature Banking, ${user1.getName()}  \\\\
              ||| ========================================||
              ||| 1. Check Balance                        ||
              ||| 2. Deposit Money                        ||
              ||| 3. Withdraw Money                       ||
              ||| 4. Print Balance                        ||
              ||| 5. Exit ATM                             ||
              |\\\\_________________________________________//
              |""".stripMargin)
        println("Please enter a number (1-5) to continue: ")
        val result = readInt()
        return result

    }

    def checkContinue(): Boolean = {
        val result = readLine("Please enter \"Yes\" if you need to complete more transactions: ")
        if (result.equals("Yes") || result.equals("yes")){
            true
        }else
            false
    }

    def checkAction(filter: Int): Boolean = {
        filter match {
            case 1 => {
                user1.getBalance()
                true
            }
            case 2 => {
                user1.deposit()
                true
            }
            case 3 => {
                user1.withdraw()
                true
            }
            case 5 => {
                println("Goodbye!")
                false
            }
            case _ => {
                println("Error: Please try again. Enter a number (1-5) ")
                val result = readInt()
                true
            }
        }
    }

    def main(args: Array[String]): Unit = {
        var action = 1
        var start = true
        openLogin()
        action = openMenu()
        while(start) {
            start = checkAction(action)
            if (start == false){
                System.exit(0)
            }
            start = checkContinue()
            if (start == true){
                action = openMenu()
            }
        }
        System.exit(0)
    }
}
