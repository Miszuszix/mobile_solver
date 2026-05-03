# Postępy Projektu - Mobile Solver

## Status Warstw (Clean Architecture)
- [x] **Domain**: Algorytmy (BFS, DFS, A*), PuzzleState, Node, Heurystyki, Walidacja rozwiązywalności.
- [/] **Presentation**: Koin (Wstępna konfiguracja), ViewModel (W trakcie), Jetpack Compose UI (Prototypowanie).
- [ ] **Data**: Room Database, Repozytoria, Statystyki.

## Kamienie Milowe
1. [x] Implementacja rdzenia algorytmicznego i optymalizacja `PuzzleState` (IntArray).
2. [x] Pełne pokrycie testami jednostkowymi warstwy Domain.
3. [ ] Konfiguracja Dependency Injection (Koin) dla warstwy UI.
4. [ ] Prototyp UI: Interaktywna siatka 3x3 z animacjami.
5. [ ] Integracja UI z ViewModel i algorytmami.

## Szczegółowa Lista zadań (UI/Presentation)
- [ ] Konfiguracja brancha `feature/ui-prototype`.
- [ ] Dodanie brakujących zależności (Koin, Compose Preview, UI Testing).
- [ ] Implementacja komponentu `PuzzleTile` (reprezentacja pojedynczego klocka).
- [ ] Implementacja komponentu `PuzzleGrid` (zarządzanie układem).
- [ ] Dodanie testów UI (`ComposeTestRule`) weryfikujących poprawność wyświetlania stanów.
- [ ] Implementacja `PuzzleViewModel` obsługującego logikę UI i komunikację z `domain`.

## Notatki Techniczne
- `PuzzleState` używa płaskiej tablicy `IntArray` dla wydajności (mapowanie 2D -> 1D: `y * width + x`).
- A* używa `visitedScores: MutableMap<PuzzleState, Int>` dla zapewnienia optymalności.
- Walidacja rozwiązywalności bazuje na liczbie inwersji i pozycji pustego pola.
- UI będzie w całości oparte o Jetpack Compose, bez plików XML (poza zasobami).
