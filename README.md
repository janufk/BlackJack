# Building
1) Download the zip file
2) Open in Java with Apache Netbeans
3) Run the BlackJackGUI file
4) Have fun playing BlackJack!

# Rules
- The player will be asked to bet a certain amount of money (should be higher than 0 and lower than your current balance).
  
- Both the player and the dealer start with 2 cards. The player's cards will both be faced up, while the dealer's cards will have one card faced up and one card faced down.
  
- Cards 2-10 are worth their number's value. A Jack, Queen and King are worth 10.
- An Ace is worth 11. However, if the person would bust with an Ace in their hand, the Ace will be worth 1 and their score will change accordingly.
  
- When the player chooses to hit, they will receive another card faced up. Their total score is displayed next to the cards.
- When the player chooses to stand, the dealer will take cards until their score is 17 or higher.
  
- If the player's score is higher than 21, they will 'bust' and their turn immediately ends. The dealer wins automatically.
- If the player's score is 21 or lower, and the dealer busts, the player wins.
- If the dealer's score is 21 or lower, and the player busts, the dealer wins.
- If the player's score is 21 or lower, and also higher than the dealer's score, the player wins.
- If the dealer's score is 21 or lower, and also higher than the player's score, the dealer wins.
- If both the player and the dealer have the same score, the game will end in a draw.

- If the player wins, their betted money will double and they will receive this back (e.g. balance = 1000, bet = 200, result = 1200)
- If the dealer wins, the player's betted money will be deducted (e.g. balance = 1000, bet = 200, result = 800)
- If the game ends in a draw, the player will receive their betted money back (e.g. balance = 1000, bet = 200, result = 1000)


# Running
- In the pop up, type in how much you would like to bet (should be higher than 0 and lower than your current balance) and click 'Confirm'.
- Click 'Hit' if you would like to take another card.
- Click 'Stand' if you would like to end your turn.
- When the round is over, click 'NewGame' to begin a new round. Your balance will be updated accordingly.

This loop will continue until you quit running the program. When you are out of balance, your only option will be to quit running the program.




