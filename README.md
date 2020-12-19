# Refactoring activities:

### Refactored to follow MVC model

- This is to delegate specific tasks to specific classes, making it easier to manage code, rather than having tasks scattered around the program.
- GameController
  - Handles scoring, controls and level changing.
- CollisionController
  - Handles intersection between actors and more.
- BoundsController
  - Makes sure that the frog cannot leave the bounds of the game, and actors that do are handled correctly.



### Created my own coordinate system

- Within actor class & bounds class
- Fixed 14 x 14 grid
- Dimensions of all actors are integer multiple of grid size
- Why?
  - For more consistent positioning of actors and objects
  - More consistent movement
  - More consistent size of objects
  - More visually appealing



### Revamped textures

- Originally some of the images were blurry
  - All images are now changed to a version that has sharp edges
- The images were inconsistently sized, so certain things were out of place
  - For example, originally End.png and FrogEnd.png had different sizes. When End.png turned into FrogEnd.png, there was a slight shift in size and position.
  - This has been changed so that they are the same size and the transition is seamless.



### Added methods for dynamically sized turtles and logs

- Done in World class
- The objects Turtle, WetTurtle and Log can now be added with a specified length.
- Instead of having multiple images for multiple lengths, they can utilize a fixed set of images to create objects of different sizes, without any limit.
- This is done by instantiating multiple actors, positioned side-by-side



### Ability to add text by entering a string parameter

- GameChar and World Classes
- Much easier to add text to views.



### Tiles

- Tiles class
- Rather than using a background image, tiles can be placed on every square of the grid.
- This makes it easier to create new level layouts without having to do any image editing.
- Tiles can have specific properties e.g. frog will die if standing on tile



### GitHub

https://github.com/hcykg2/COMP2042_CW_hcykg2/