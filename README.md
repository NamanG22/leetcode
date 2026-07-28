# LeetCode Solutions

Personal archive of LeetCode problems I solve over time. Each problem lives in its own folder.

## Purpose

I use this repo to track my LeetCode journey — the problems I attempt, the approaches I try, and how my thinking evolves. It is meant as a record of my own work, not as a polished reference library.

## What to expect

- **My own solutions first.** Every solution here is something I came up with on my own, without looking at editorials, discussions, or other people's code while solving.
- **Not always optimal.** These are not guaranteed to be the fastest or most memory-efficient approaches. They reflect what made sense to me at the time.
- **Revisits happen.** I sometimes run into a problem I have solved before. When that happens, I may add an updated solution or note in the commit message if I found a better approach than my previous attempt.
- **Commit messages include context.** When available, commits mention runtime, memory beats, and complexity so I can compare attempts over time.

## Structure

```
LC<number>/
  ├── Solution.java    # first attempt
  ├── Solution1.java   # revisit / alternative approach (optional)
  └── SolutionN.java   # further attempts if needed
```

| File | Meaning |
|------|---------|
| `Solution.java` | First solution I wrote for the problem |
| `Solution1.java`, `Solution2.java`, … | Later attempts — usually a different idea or an optimization |

Folders are named `LC` + the LeetCode problem number (e.g. `LC1081` for problem 1081).

Each `Solution*.java` is a standalone class with the LeetCode method and often a small `main` for quick local checks.

## Problems

| Folder | Problem | Notes |
|--------|---------|-------|
| [LC406](LC406/) | Queue Reconstruction by Height | |
| [LC1081](LC1081/) | Smallest Subsequence of Distinct Characters | Daily — 19 Jul 2026 |
| [LC1260](LC1260/) | Shift 2D Grid | Daily — 20 Jul 2026 |
| [LC1464](LC1464/) | Maximum Product of Two Elements in an Array | Daily — 27 Jul 2026 |
| [LC3499](LC3499/) | Maximize Active Section with Trade I | Daily — 21 Jul 2026; `Solution1` = single-pass zero-run handoff |
| [LC3517](LC3517/) | Smallest Palindromic Rearrangement I | Daily — 28 Jul 2026 |
| [LC2126](LC2126/) | Destroying Asteroids | Daily — 31 May 2026 |
| [LC2144](LC2144/) | Minimum Cost of Buying Candies With Discount | Daily — 1 Jun 2026; `Solution1` = hash-array revisit |
| [LC3532](LC3532/) | Path Existence Queries in a Graph I | Daily — 9 Jul 2026 |
| [LC3633](LC3633/) | Earliest Finish Time for Land and Water Rides | Daily — 2 Jun 2026 |
| [LC3635](LC3635/) | Earliest Finish Time for Land and Water Rides II | Daily — 3 Jun 2026; has `Solution1` |
| [LC3751](LC3751/) | Total Waviness of Numbers in Range I | Daily — 3 Jun 2026; has `Solution1` |
| [LC3867](LC3867/) | Sum of GCD of Formed Pairs | Daily — 16 Jul 2026 |

## How to run

From any problem folder (example):

```bash
javac LC1081/Solution.java && java -cp LC1081 Solution
```

Or open the file and run `main` from your IDE.

## Disclaimer

This is a learning log, not a competitive programming repo. If you are looking for textbook-optimal solutions, there are better places for that. If you want to see how one person thinks through problems — including the messy, non-optimal attempts — you are in the right place.
