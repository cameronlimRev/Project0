import scala.io.StdIn._
import java.sql.Connection
import java.sql.DriverManager
import java.io._

import user.User

/** TODO LIST
 * => 1.Delete User
 * => 2. Create databases for Users.
 * => 2. Integrate SQL into Deposit/Withdraw/other functions
 * => 3. Print user balance to file.
 * => Transfer */

object ATM{
    // Globals
    var currentUser = ""
    var currentPin = 0;
    //SQL SETUP AND EXAMPLE
    val url = "jdbc:mysql://localhost:3306/demodatabase"
    val driver = "com.mysql.cj.jdbc.Driver"
    val username = "root"
    val password = "sqlProject0"
    var connection: Connection = DriverManager.getConnection(url, username, password)
    var user = new User("")


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
                val statement = connection.createStatement
                val rs = statement.executeQuery(s"SELECT count(*) AS counter FROM userlogins WHERE userName=('$getUsername') AND userPin=($getPin)")
                var count = ""
                rs.next()
                count = rs.getString("counter")
                if (count.equals("1")){
                    println("Login authorized...")
                    println("Loading the menu...")
                    currentUser = getUsername
                    currentPin = getPin
                    var user = new User(currentUser)
                }else{
                    println("You've entered the wrong credentials. Please try again or create a new account.")
                    openLogin()
                }
            } catch {
                case e: Exception => e.printStackTrace
            }
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
            val statement = connection.createStatement
            val pstmt = connection.prepareStatement("INSERT INTO `userlogins`(userName,userPin) VALUES (?, ?)")
            pstmt.setString(1, requestedUsername)
            pstmt.setInt(2, requestedPin)
            pstmt.executeUpdate()
            println("Your new account has been created! Taking you back to the login.")
        } catch {
            case e: Exception => e.printStackTrace
        }
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
              ||| 5. Delete Account                       ||
              ||| 6. Exit                                 ||
              |\\\\_________________________________________//
              |""".stripMargin)
        println("Please enter a number (1-6) to continue: ")
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
               user.getBalance(currentUser, currentPin)
                true
            }
            case 2 => {
                user.deposit(currentUser, currentPin)
                true
            }
            case 3 => {
                user.withdraw(currentUser, currentPin)
                true
            }
            case 4 => {
                user.printBalance(currentUser, currentPin)
                true
            }
            case 5 => {
                try {
                    val statement = connection.createStatement
                    val confirmation = readLine("Are you sure you want to delete? (Enter 'Yes' to confirm): ")
                    if (confirmation.equals("Yes")) {
                        statement.executeUpdate(s"DELETE FROM userdata WHERE user_id=(SELECT id from userlogins WHERE userName='$currentUser' AND userPin='$currentPin')")
                        statement.executeUpdate(s"DELETE FROM userlogins WHERE userName='$currentUser' AND userPin='$currentPin'")
                        println("User Deleted. Taking you to the login.")
                        openLogin()
                    } else{
                        println("Cancelled. Taking you back to the menu.")
                        openMenu()
                    }
                } catch {
                    case e: Exception => e.printStackTrace
                }
                true
            }
            case 6 => {
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
        connection.close
        System.exit(0)
    }
}
