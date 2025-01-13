# Simple Macros

**Simple Macros** is a mod for creating macros can can run a command or commands at the press of a button or a custom command.

### Examples
**Keyboard Shortcut**: You want to teleport to ``0, 0, 0`` so you make a macro that does that ``/tp 0, 0, 0``. Then you set it up to a keyboard shortcut ``ctrl + T``. Whenever you press the keyboard shortcut it teleports you to ``0, 0, 0``.

**Custom Command**: You have multiple commands you need to run ``/setblock ~ ~20 ~ glass``, ``/tp ~ ~21 ~``. Like in **Example 1**, you can make a keyboard shortcut to run them all, or you could make a simple command like ``/raise`` to run them.

**Custom Command w/ Arguments**: Like before, you can make **Custom Commands** if you have multiple commands you need to run, but some of them might require arguments. E.g. ``/tp X Y Z``, that requires 3 arguments, X Y and Z. When making a **Custom Command** you can add arguments with names/identifiers to reference in the command(s). E.g. ``/summon creeper arg1 arg2 arg3``, with the custom command being ``/create-creeper arg1 arg2 arg3`` that references the same arguments that replace the X Y and Z values for ``/summon creeper``.