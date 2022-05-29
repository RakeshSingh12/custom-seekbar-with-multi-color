# custom-seekbar-with-multi-color 

In onDraw method, we’ve calculated width of progress item with respect to the width of whole progressbar. Left position for the progress item will be right position of the previous item, for the first progress item, it will be 0. Use left position and width of progress item to get right position of the item. Now, draw a rectangle using these positions. Call super.onDraw(canvas) method right after add your custom changes.
