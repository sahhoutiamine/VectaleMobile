$data = @'
2025-02-10 12:00:00|If at first you don't succeed; call it version 1.0
2025-02-11 12:00:00|The computer was born to solve problems that did not exist before.
2025-02-19 12:00:00|Real programmers count from 0.
2025-02-20 12:00:00|Hardware: The parts of a computer system that can be kicked.
2025-02-21 12:00:00|Computer science is no more about computers than astronomy is about telescopes.
2025-02-27 12:00:00|One person's constant is another person's variable.
2025-02-28 12:00:00|Simplicity is the soul of efficiency.
2025-03-02 12:00:00|Code is like humor. When you have to explain it, it’s bad.
2025-03-08 12:00:00|Fixing your own mistakes is being a developer. Fixing someone else's mistakes is being a senior developer.
2025-03-15 12:00:00|Don't comment bad code - rewrite it.
'@

$filePath = "c:\Users\ycode\Desktop\FUN\VectaleMobile\commitsfile.md"

$lines = $data -split "`r?`n"
foreach ($line in $lines) {
    if ($line -match "^(.+)\|(.+)$") {
        $date = $Matches[1]
        $msg = $Matches[2]
        
        # Add content to file
        Set-Content -Path $filePath -Value "Commit for $date"
        
        # Git operations
        git add .
        $env:GIT_AUTHOR_DATE = $date
        $env:GIT_COMMITTER_DATE = $date
        git commit -m "$msg"
        git push
        
        Write-Host "Committed for date: $date"
    }
}

# Cleanup
Remove-Item Env:GIT_AUTHOR_DATE -ErrorAction SilentlyContinue
Remove-Item Env:GIT_COMMITTER_DATE -ErrorAction SilentlyContinue
# Clear the file as before
Set-Content -Path $filePath -Value ""
