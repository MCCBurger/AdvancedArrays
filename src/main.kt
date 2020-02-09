fun main() {
    //Declare array of supplies and quantity
    var supplies = arrayOf("Regular Bun", "Poppy Seed Bun", "Hotdog", "Mustard", "Relish")
    var qty = arrayOf("10", "20", "30", "40", "50")
    var inventory = arrayOf<Array<String>>()
    var item = ""
    var inStock = -1
    var amt = 0

    //Fill 2D array
    inventory += supplies
    inventory += qty


    //Print all supplies in list
    println("======================== HOT DOG CART ===================")
    for (i in 0..inventory[0].size - 1)
        println("${inventory[0][i]}: ${inventory[1][i]}")

    //search for a specific item
    print("Which item would you like to search for? ")
    item = readLine()!!.toString()
    inStock = search(item, inventory)

    //If item on hand print amount
    if (inStock != -1)
        println("$item is in the inventory and you have ${inventory[1][inStock]} of them")
    else if (item.equals("Ketchup", ignoreCase = true))
        println("Not on a Chicago dog")
    else
        println("I'm sorry that item is not in your inventory....")

    //Look to see if item is in inventory to adjust
    print("What item would you like to adjust the quantity of? ")
    item = readLine()!!.toString()
    inStock = search(item, inventory)

    //Adjust quantity of item
    if (inStock != -1) {
        print("The $item is in your inventory, Enter a value to adjust the quantity: ")
        amt = readLine()!!.toInt()
        println("===================== CHANGES TO INVENTORY =========================")

        if (((inventory[1][inStock]).toInt() + amt) < 0) {
            println("You do not have enough on hand.....")

            print("Item: $item, Original amount: ${inventory[1][inStock]}, Amount Changed: $amt,")
            inventory[1][inStock] = (0).toString()
            print(" New amount: ${inventory[1][inStock]}\n")

        } else {
            print("Item: $item, Original amount: ${inventory[1][inStock]}, Amount Changed: $amt,")
            inventory[1][inStock] =
                ((inventory[1][inStock]).toInt() + amt).toString() //Is there an easier way to do this?
            print(" New amount: ${inventory[1][inStock]}\n")
        }
        println("======================== HOT DOG CART ===================")
        for (i in 0..inventory[0].size - 1)
            println("${inventory[0][i]}: ${inventory[1][i]}")
    }
    else
        println("I'm sorry that item is not in your inventory....")
}

//Returns the location of the item if its in the array, returns -1 if item is not
fun search(n: String, arr: Array<Array<String>>): Int {
    var loc = -1
    for (i in 0..arr[0].size - 1) {
        if (arr[0][i].equals(n, ignoreCase = true))
            loc = i
    }
    return loc
}



