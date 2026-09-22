# Journal
The base case is when the item is a file, so the method returns 1. The general case is a folder, where the method checks the items inside it. Each call gets closer to a file, so eventually the recursion stops.
