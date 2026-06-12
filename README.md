<!--suppress SpellCheckingInspection, GrazieInspection -->

# Notifications Library

A framework-independent notification library built with Java 21.

This library provides a unified API for sending notifications through
multiple channels, including email, SMS, and push notifications.
It also supports different providers for each channel.

## Features

- Unified notification API
- Email notifications
- SMS notifications
- Push notifications
- Multiple providers per channel
- Builder-based configuration
- Factory and Strategy patterns
- Custom exception handling
- Unit tests with JUnit 5 and Mockito
- Extensible architecture based on SOLID principles

## Requirements

- Java 21 or higher
- Maven 3.x

## Installation

Clone the repository:

```bash
git clone <repository-url>
```

Build the project:

```bash
mvn clean package
```

Run the tests:

```bash
mvn test
```

## Quick Start

### Create the Configuration

```text
NotificationConfiguration configuration =
        new NotificationConfigurationBuilder()
                .emailProvider(ProviderType.SENDGRID)
                .smsProvider(ProviderType.TWILIO)
                .pushProvider(ProviderType.FIREBASE)
                .build();
```

### Create the Service

```text
NotificationService notificationService =
        new NotificationService(configuration);
```

### Send an Email

```text
Notification notification =
        new Notification(
                "user@example.com",
                "Hello from Notifications Library"
        );

NotificationResult result =
        notificationService.send(
                ChannelType.EMAIL,
                notification
        );

System.out.println(result.getMessage());
```

## Supported Channels

| Channel           | Supported |
|-------------------|-----------|
| Email             | Yes       |
| SMS               | Yes       |
| Push notification | Yes       |
| Slack             | No        |

## Supported Providers

### Email

- SendGrid
- Mailgun

### SMS

- Twilio

### Push Notification

- Firebase

## Configuration

The library is configured entirely through Java code.

Example:

```text
NotificationConfiguration configuration =
        new NotificationConfigurationBuilder()
                .emailProvider(ProviderType.SENDGRID)
                .smsProvider(ProviderType.TWILIO)
                .pushProvider(ProviderType.FIREBASE)
                .build();
```

No YAML, properties, or framework-specific configuration files are required.

## Error Handling

The library provides the following custom exceptions:

### ValidationException

Thrown when notification data is invalid.

### NotificationSendException

Thrown when a provider fails while sending a notification.

### UnsupportedChannelException

Thrown when an unsupported channel is requested.

### UnsupportedProviderException

Thrown when an unsupported provider is requested.

### ConfigurationException

Thrown when the library configuration is invalid.

Example:

```text
try {
    notificationService.send(
            ChannelType.EMAIL,
            notification
    );
} catch (ValidationException e) {
    System.out.println(e.getMessage());
}
```

## Main Components

### NotificationService

Main entry point of the library.

### NotificationFactory

Creates the appropriate sender for the selected channel.

### NotificationSender

Common abstraction for all notification channels.

### NotificationProvider

Common abstraction for all providers.

### NotificationConfigurationBuilder

Builds a valid notification configuration.

## Extending the Library

### Add a New Channel

1. Create a new sender implementation.
2. Add a new value to `ChannelType`.
3. Register the sender in `NotificationFactoryImpl`.

### Add a New Provider

1. Implement `NotificationProvider`.
2. Add a new value to `ProviderType`.
3. Register the provider in `ProviderFactory`.

## Testing

The project includes:

- JUnit 5 tests
- Mockito tests
- Validation tests
- Factory tests
- Configuration tests
- Sender tests

Run all tests:

```bash
mvn test
```

## Security Recommendations

- Do not hardcode production credentials.
- Store API keys in environment variables.
- Rotate credentials periodically.
- Use the minimum permissions required.

## Docker

Build the image:

```bash
docker build -t notifications-library .
```

## Technologies

- Java 21
- Maven
- Lombok
- JUnit 5
- Mockito

## AI Usage

This project was developed with assistance from ChatGPT by OpenAI.

AI was used as a development assistant for architecture discussions,
design patterns, testing strategies, and documentation.

Final implementation decisions, project structure, and code organization
were reviewed and adapted by the developer.
