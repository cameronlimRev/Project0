import scala.io.StdIn._
import user.User
import java.sql.Connection
import java.sql.DriverManager

object ATM{
    // Globals
    var currentUser = ""
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
        print("Pin: ")
        var getPin = readInt()
        if (getUsername.equals("New")){
            createAccount()
        }else{
            try {
                Class.forName(driver)
                connection = DriverManager.getConnection(url, username, password)
                val statement = connection.createStatement
                val rs = statement.executeQuery(s"SELECT count(*) AS counter FROM userlogins WHERE userName=('$getUsername') AND userPin=($getPin)")
                var count = ""
                rs.next()
                count = rs.getString("counter")
                if (count.equals("1")){
                    println("Login authorized...")
                    println("Loading the menu...")
                    currentUser = getUsername
                }else{
                    println("You've entered the wrong credentials. Please try again or create a new account.")
                    openLogin()
                }
            } catch {
                case e: Exception => e.printStackTrace
            }
            connection.close
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
            println("Your new account has been created! Taking you back to the login.")
        } catch {
            case e: Exception => e.printStackTrace
        }
        connection.close
        openLogin()
    }

    def openMenu(): Int = {
        println(
            s"""  _______________________________________
              |//   Welcome to Revature Banking, $currentUser  \\\\
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
