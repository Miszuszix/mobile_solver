# Postępy Projektu - Mobile Solver

## Status Warstw (Clean Architecture)
- [x] **Domain**: Algorytmy (BFS, DFS, A*), PuzzleState, Node, Heurystyki, Walidacja rozwiązywalności.
- [x] **Presentation**: Koin (Pełna konfiguracja), ViewModel (Zaimplementowany), Jetpack Compose UI (Prototyp 3x3 działa).
- [ ] **Data**: Room Database, Repozytoria, Statystyki.

## Kamienie Milowe
1. [x] Implementacja rdzenia algorytmicznego i optymalizacja `PuzzleState` (IntArray).
2. [x] Pełne pokrycie testami jednostkowymi warstwy Domain.
3. [x] Konfiguracja Dependency Injection (Koin) dla warstwy UI.
4. [x] Prototyp UI: Interaktywna siatka 3x3 z ViewModel i testami.
5. [ ] Integracja UI z algorytmami (Solver Flow).
6. [ ] Animacje i Drag & Drop.

## Szczegółowa Lista zadań (UI/Presentation)
- [x] Konfiguracja brancha `feature/ui-prototype`.
- [x] Dodanie brakujących zależności (Koin, Compose Preview, UI Testing, Turbine).
- [x] Implementacja komponentu `PuzzleTile`.
- [x] Implementacja komponentu `PuzzleGrid`.
- [x] Dodanie testów UI (`ComposeTestRule`) i ViewModelu (`Turbine`).
- [x] Implementacja `PuzzleViewModel` obsługującego logikę UI i komunikację z `domain`.
- [ ] Animacje przesunięć kafelków (MotionLayout lub AnimateItem).
- [ ] Integracja przycisku "Solve" i wizualizacja kroków algorytmu.

## Baza Wiedzy (Learnings)
### Jetpack Compose
- **State Hoisting**: Komponenty UI są "głupie" (stateless) - dostają dane i wysyłają zdarzenia w górę.
- **Lambda `{}` vs `()`**: W `()` parametry konfiguracyjne, w `{}` kod wykonywany "później" (np. po kliknięciu).
- **Modifier.aspectRatio(1f)**: Gwarantuje kwadratowy kształt niezależnie od rozmiaru ekranu.
- **Testing Semantics**: Testujemy to, co widzi użytkownik (`onNodeWithText`), co czyni testy odpornymi na zmiany w kodzie.

### ViewModel & Context
- **ViewModel**: Most między UI a Domain. Przetrzymuje stan odporny na "Configuration Changes" (obrót ekranu).
- **Configuration Changes**: Zdarzenia (obrót, zmiana języka), które niszczą Activity. ViewModel przeżywa te zmiany.
- **Context**: Interfejs do usług systemowych Androida. **NIGDY** nie trzymamy go w ViewModelu (Memory Leaks!).
- **DI (Koin)**: Pozwala uniknąć ręcznego tworzenia `ViewModelProvider.Factory`.
