## Splash _`MVP`_ ##
Shows a mock of splash screen, in an actual scenario, it is used to load resources in the background

#### Main Functionality ####

- verirfies network connectivity
- Mocks a splash delay of `TWO SECONDS` by presenter
- Shows only on first launch of application

#### Construction Elements / Dependencies ####

- Module to provide Dagger2 support
- Component
- Interactor
- Presenter
- XML layout


#### Propogates Changes ####
- Launches `NextActivity` after the splash delay

