package tictactoe

fun main() {

    val grid = arrayOf(
            arrayOf(' ',' ', ' '),
            arrayOf(' ',' ', ' '),
            arrayOf(' ',' ', ' ')
    )
    printGrid(grid)
    var chance = false
    while(!analyze(grid)) {

        do{
            print("Enter the coordinates: ")
            val (x,y) = readLine()!!.split(" ")

            if(valid(x,y,grid)) {
                grid[x.toInt()-1][y.toInt()-1] = if (chance) 'O' else 'X'
                chance = chance.not()
                break
            }
        }while(true)


        printGrid(grid)
    }



}

fun analyze(grid: Array<Array<Char>>): Boolean {

    var x = false
    var y = false
    for (i in 0..2) {
        if(grid[i][0]==grid[i][1]&& grid[i][1]==grid[i][2]) {
            if(grid[i][0]=='X') x = true
            if(grid[i][0]=='O') y = true
        }
    }

    for (i in 0..2) {

        if(grid[0][i]==grid[1][i]&& grid[1][i]==grid[2][i]) {
            if(grid[0][i]=='X') x = true
            if(grid[0][i]=='O') y = true
        }

    }
    if (grid[0][0]==grid[1][1]&&grid[1][1]==grid[2][2]) {
        if(grid[0][0]=='X') x = true
        if(grid[0][0]=='O') y = true
    }
    if (grid[0][2]==grid[1][1]&&grid[1][1]==grid[2][0]) {
        if(grid[0][2]=='X') x = true
        if(grid[0][2]=='O') y = true
    }


    if(x&&y) {
        print("Draw")
        return true
    }

    else if(x) {
        print("X wins")
        return true
    }

    else if(y){
        print("O wins")
        return true
    }
    else
        return false
}

fun valid(a: String, b: String, grid: Array<Array<Char>>): Boolean {

    val x = a.toInt()
    val y = b.toInt()
    if(x < 1 || x > 3 || y <1 || y>3) {
        println("Coordinates should be from 1 to 3")
        return false
    }

    if (grid[x-1][y-1] != ' ') {
        println("This cell is occupied! Choose another one!")
        return false
    }

    return true
}



fun printGrid(grid: Array<Array<Char>>) {
    println("---------")
    for(i in 0..2)
        println("| ${grid[i][0]} ${grid[i][1]} ${grid[i][2]} |")
    println("---------")
}