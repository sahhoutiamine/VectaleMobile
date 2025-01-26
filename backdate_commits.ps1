$data = @'
2025-01-26 10:30:00|It works on my machine. ¯\_(ツ)_/¯
2025-01-27 14:15:00|Code never lies, comments sometimes do. — Ron Jeffries
2025-01-28 16:45:00|There are only two hard things in Computer Science: cache invalidation and naming things. — Phil Karlton
2025-02-01 09:20:00|99 little bugs in the code, 99 little bugs. Take one down, patch it around, 127 little bugs in the code.
2025-02-02 11:35:00|First, solve the problem. Then, write the code. — John Johnson
2025-02-04 13:50:00|Talk is cheap. Show me the code. — Linus Torvalds
2025-02-08 15:10:00|Debugging is like being the detective in a crime movie where you are also the murderer.
2025-02-09 10:25:00|Any fool can write code that a computer can understand. Good programmers write code that humans can understand. — Martin Fowler
2025-02-11 16:40:00|I don't always test my code, but when I do, I do it in production.
2025-02-12 14:05:00|If debugging is the process of removing bugs, then programming must be the process of putting them in. — Edsger Dijkstra
2025-02-13 11:55:00|Programming is 10% writing code and 90% understanding why it's not working.
2025-02-15 09:30:00|The best thing about a boolean is even if you are wrong, you are only off by a bit.
2025-02-16 15:20:00|It's not a bug – it's an undocumented feature.
2025-02-17 12:45:00|Why do programmers prefer dark mode? Because light attracts bugs!
2025-02-18 10:10:00|Before software can be reusable, it first has to be usable. — Ralph Johnson
2025-02-22 16:30:00|There are two ways to write error-free programs; only the third one works. — Alan J. Perlis
2025-02-23 13:15:00|Weeks of coding can save you hours of planning.
2025-02-24 14:50:00|Software is like entropy: It is difficult to grasp, weighs nothing, and obeys the Second Law of Thermodynamics. — Norman Augustine
2025-02-25 11:00:00|I would love to change the world, but they won't give me the source code.
2025-02-26 17:35:00|Always code as if the guy who ends up maintaining your code will be a violent psychopath who knows where you live. — John Woods
2025-03-01 09:15:00|Programmer: A machine that turns coffee into code.
2025-03-02 15:40:00|Software and cathedrals are much the same – first we build them, then we pray. — Sam Redwine
2025-03-04 12:20:00|Copy-and-Paste was programmed by programmers for programmers actually.
2025-03-08 10:50:00|One man's crappy software is another man's full-time job. — Jessica Gaston
2025-03-09 14:25:00|A good programmer is someone who always looks both ways before crossing a one-way street. — Doug Linder
2025-03-10 16:05:00|Deleted code is debugged code. — Jeff Sickel
2025-03-11 13:30:00|git commit -m 'I am too tired to write a meaningful commit message'
2025-03-15 11:45:00|Programming is the art of doing one thing at a time. — Michael Feathers
'@

$filePath = "c:\Users\ycode\Desktop\FUN\VectaleMobile\commitsfile.md"

$lines = $data -split "`r?`n"
foreach ($line in $lines) {
    if ($line -match "^(.+)\|(.+)$") {
        $date = $Matches[1]
        $msg = $Matches[2]
        
        Set-Content -Path $filePath -Value "Commit for $date"
        git add .
        $env:GIT_AUTHOR_DATE = $date
        $env:GIT_COMMITTER_DATE = $date
        git commit -m "$msg"
        git push
        
        Write-Host "Committed: $date"
    }
}

Remove-Item Env:GIT_AUTHOR_DATE -ErrorAction SilentlyContinue
Remove-Item Env:GIT_COMMITTER_DATE -ErrorAction SilentlyContinue
