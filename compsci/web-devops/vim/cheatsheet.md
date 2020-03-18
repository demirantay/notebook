# Vim Cheatsheet

### Basic Usage

- `vim or vi` -- Run vim and open the given filename.
- `:w` -- Save file.
- `:x or SHIFT ZZ` -- Save and exit.
- `:q` -- Exit if no changes have been made.
- `:q!` -- Exit and undo any changes made.
- `:set nu` -- Display line numbers.

### Entering Insert Mode

- `i` -- At the cursor.
- `a` -- After the cursor.
- `I` -- Before the current line.
- `A` -- After the current line.
- `o` -- Insert a new line after the current line.
- `O` -- Insert a new line before the current line.
- `C` -- Ovewrite the whold current line.
- `ESC` -- Exit Insert mode.

### Movement

- `h` -- Move left one character.
- `j` -- Move down one character.
- `k` -- Move up one character.
- `l` -- Move right one character.
- `w` -- Move forward one word.
- `b` -- Move to the start of the word.
- `e` -- Move to the end of the word.
- `(` -- Move back one sentence.
- `)` -- Move forward one sentence.
- `{` -- Move back one paragraph.
- `}` -- Move forward one paragraph.
- `^` -- Move to the beginning of the line.
- `$` -- Move to the end of the line.
- `<n>G` -- Move to the nth line.
- `G` -- Move to the last line
- `gg` -- Move to the first line.
- `%` -- Move to the matching bracket.

### Cut and Paste

- `p` -- Paste the clipboard contents.
- `yy` -- Yank (copy) a line.
- `yw` -- Yank a word.
- `y$` -- Yank to the end of the line.

### Deleting

- `x` -- Delete a single character.
- `D` -- Delete the rest of the line
- `dd` -- Delete the entire current line.
- `ndw` -- Delete the next n words.
- `ndd` -- Delete the next n lines.
- `:x,yd` -- Delete from line x through to line y.

### Search and Replace

- `/pattern` -- Search for pattern.
- `n` -- Find the next occurrence of pattern.
- `:%s/pattern/replace/g` -- Replace every occurrence of pattern with replace..
