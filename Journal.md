# Journal
The base case is when the item is a file, so the method returns 1. The general case is a folder, where the method checks the items inside it. Each call gets closer to a file, so eventually the recursion stops.

findLargestFileRecursive returns null when there are no files because there is no longest file in return. The folder checks each reult before comparing sizes, which prevents an error.

The recursive version is easier for me to understand because the code is shorter and it naturally goes through the folders. The iterative version uses a stack, so it takes more code, but it does not use recursion.

Whenever I finished the code, I hade some red underlines in  some parts of the code as in words in line/s "40", and "119". Theres also a semi colon error as well "72". My main class "{" is red, ive tried removing and adding it none of it seems to fix it, it just makes more errors.
