I want to create a snake game similar to http://www.menet.umn.edu/~dockt036/snake.html
to practice MVC design. Hopefully I can make it into a playable JAR. The game above has a link
to the source code in JavaScript, so maybe I'll compare it with my design when I'm done.

7/16: 
Beginning to construct the model. A model has a Snake, which is made up of Cells.
The view is pretty simple and largely inspired by OOD homework. Using an IViewModel to pass information
into the view and making sure the model is immutable worked well for me before, so I'm doing that again.

One notable difference between this and the animation project is the timer cannot be located in the view because
the model itself changes with each tick (the snake moves forward). Thus, the timer is located in the main 
method. I added repaint() to SnakeView and overrode the existing JFrame method in CanvasView so that the 
timer can call view.repaint() and model.advance().

I've written the model and view pretty quickly, and I am starting to work on the controller now. I'm wondering
if this game would work better using a class which extends World, like the ships and bullets game from 
Fundies II. I think this makes a main class and method no longer necessary. I'd like to keep the controller
but at the moment I'm not sure where to add key listeners.

Update I realized ControllerImpl can implement both Controller and KeyListener, so I'm going to try that.

That didn't work, I think because the program is displayed by calling controller.run(), it can't simultaneously
be listening for a key event. I tried making a new class Listener which implements KeyListener and then giving
the controller a Listener object. It would be nice if in the Timer I could call listener.listen() or something
so that the controller is listening for key events but still advancing the model and still repainting the view,
but I'm not sure what would go in the body of listen().

7/17:
World is a part of a Northeastern library, so I don't want to use that. My new branch will include a Features
interface that is implemented by ControllerImpl, and I'm going to change the view so that
CanvasView implements KeyListener and has a reference of type Features.

The timer is now located in controller.run(). When I run the main method the view seems to be working
correctly, but nothing happens when I press any keys. I went back through and added tests for the model
which all pass, and now I'll work on testing the controller. I'm going to review how to test using a 
mock because I think the issue is likely happening here.

I made a mock view too and all the controller tests pass so it is actually calling the model. Still
nothing happens when I press any keys.

7/19:
I finally figured out why the model was advancing but the view wasn't changing! In Field the snake field
is assigned by calling this.model.getSnake() in the constructor, so it is a List<Cell> as it exists at the beginning, 
but that list does not get update as the model advances, so I added this.snake = this.model.getSnake();
in paintComponent(). The key listeners are still not working but at least it's moving again.

It WORKS I just had to call view.addKeyListener(field). Now the snake can move around using the keys,
next I'll work on having it grow in length when it eats food.

I just had to add an if statement to make it grow. I'm adding a JPanel to display the length of the snake
and have a new game button appear once the game ends. I'm probably done for now, I'm going to make this into
a JAR. I might add stuff to the main method so that the user can adjust the width, length, scale, and speed
through the run configurations or add more tests later.

7/22:
After playing the game for a few days I have noticed a couple bugs / things to improve.
1) The length counter is not accurate (should increment by 5, but goes from 1 to 7).
2) Sometimes the food will appear beneath the snake, so there is a bug in the newFood() method.
3) Hitting the New Game button does not close the previous window.
4) Changes in width, height, or scale in the main method do not translate to a new game. 
5) The snake starts moving right as soon as the game as launched, it would be better to wait for the 
   user to input a direction.
   
7/29:
I fixed issue 1 by adding the head to the body before removing a cell from the tail. This makes the snake
actually be the right size. The counter wasn't inaccurate, the moveForward() method was incorrect.
I'm not sure the contains() method in Snake actually overrode contains() correctly, so I rewrote it to 
containsCell(Cell c). The tests still pass, but it is difficult to directly test newFood(). I close
the previous window by adding this.dispose() to the gameOver() method in CanvasView. Changes are now
translated to the new game by calling this.model.getWidth(), this.model.getHeight(), and this.scale.
I added a private boolean started to SnakeModelImpl. Then I added a void method start() to IViewModel,
which is called as soon as an arrow key is pressed in Field. moveForward() isn't called until started is 
true. I also changed the snake constructor so that heading is initialized to null, so the first move can be
in any direction.
   
