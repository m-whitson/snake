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
World is a part of a Northeastern library so I don't want to use that. My new branch will include a Features
interface that is implemented by ControllerImpl, and I'm going to change the view so that
CanvasView implements KeyListener and has a reference of type Features.