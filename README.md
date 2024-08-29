# ArtSpace

**ArtSpace** is an Android app built using Jetpack Compose, designed to showcase different pieces of artwork. Users can navigate through various artworks and view their titles and years using "Previous" and "Next" buttons.

## Features

- Display artwork images.
- Show the title and year of the currently displayed artwork.
- Navigate through artworks using "Previous" and "Next" buttons.

## Getting Started

### Prerequisites

- Android Studio Arctic Fox (2020.3.1) or higher
- Kotlin 1.6.0 or higher

### Clone the Repository

1. Clone this repository using Git:
   ```bash
   git@github.com:rayynaldgitau/ArtSpace.git
   ```

2. Navigate to the project directory:
   ```bash
   cd artspace
   ```

### Build and Run the App

1. Open the project in Android Studio.

2. Make sure that you have the necessary SDKs and tools installed.

3. Sync the project with Gradle files by clicking the "Sync Project with Gradle Files" button in the toolbar.

4. Run the app on an emulator or a physical device by clicking the "Run" button in Android Studio.

## Code Overview

### `MainActivity`

- The `MainActivity` class extends `ComponentActivity` and sets up the app's content using Jetpack Compose.
- `ArtSpaceTheme` is applied to the content to maintain consistent styling.
- The `ArtSpaceScreen` composable is used as the main UI component.

### `ArtSpaceScreen`

- Manages the state for artwork, including the current artwork, title, and year.
- Displays the artwork using the `ArtworkDisplay` composable.
- Shows the title and year of the artwork using the `ArtworkTitle` composable.
- Provides "Previous" and "Next" buttons for navigation between artworks.

### `ArtworkDisplay`

- Displays the current artwork image.
- Uses the `Image` composable from Jetpack Compose to render the artwork.

### `ArtworkTitle`

- Displays the title and year of the current artwork.
- Uses `Text` composables to show this information with appropriate styling.

### `DefaultPreview`

- Provides a preview of the `ArtSpaceScreen` composable in Android Studio.

## Resources

- **Artwork Images**: Images used for the artworks are located in the `res/drawable` directory.
- **Strings**: String resources are defined in `res/values/strings.xml`.
- **Colors**: Color resources are defined in `res/values/colors.xml`.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request with your changes.


## Contact

For any questions or suggestions, please contact [raynaldgitau@gmail.com](raynaldgitau@gmail.com).

---

Feel free to customize this README further based on your specific needs or preferences.
