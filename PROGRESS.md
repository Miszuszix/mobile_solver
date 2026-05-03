# Postępy Projektu - Mobile Solver

## Status Warstw (Clean Architecture)
- [x] **Domain**: Algorytmy (BFS, DFS, A*), PuzzleState, Node, Heurystyki, Walidacja rozwiązywalności.
- [ ] **Presentation**: Koin, ViewModel, Jetpack Compose UI.
- [ ] **Data**: Room Database, Repozytoria, Statystyki.

## Kamienie Milowe
1. [x] Implementacja rdzenia algorytmicznego i optymalizacja `PuzzleState` (IntArray).
2. [x] Pełne pokrycie testami jednostkowymi warstwy Domain.
3. [ ] Konfiguracja Dependency Injection (Koin).
4. [ ] Pierwszy prototyp UI (Grid 3x3).

## Notatki Techniczne
- `PuzzleState` używa płaskiej tablicy `IntArray` dla wydajności (mapowanie 2D -> 1D: `y * width + x`).
- A* używa `visitedScores: MutableMap<PuzzleState, Int>` dla zapewnienia optymalności.
- Walidacja rozwiązywalności bazuje na liczbie inwersji i pozycji pustego pola.
