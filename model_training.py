import tensorflow as tf
from tensorflow.keras.preprocessing.image import ImageDataGenerator
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Conv2D, MaxPooling2D, Flatten, Dense, Dropout
import matplotlib.pyplot as plt
import os

# Define path to the training data directory
train_data_dir = "data/asl_alphabet_train"  # Ensure this directory directly contains folders for each class (A, B, C, ..., Z, del, nothing, space)

# Image dimensions
img_width, img_height = 64, 64
input_shape = (img_width, img_height, 3)

# Create an ImageDataGenerator with rescaling and validation split
train_datagen = ImageDataGenerator(
    rescale=1.0 / 255,
    validation_split=0.2  # 20% of data for validation
)

# Create training and validation generators
train_generator = train_datagen.flow_from_directory(
    train_data_dir,
    target_size=(img_width, img_height),
    batch_size=32,
    class_mode="categorical",  # Use categorical since we have multiple classes
    subset="training"
)

validation_generator = train_datagen.flow_from_directory(
    train_data_dir,
    target_size=(img_width, img_height),
    batch_size=32,
    class_mode="categorical",  # Ensure this is set for multi-class classification
    subset="validation"
)

# Debugging: Print the detected classes and their indices
print("Classes Detected:", train_generator.class_indices)
print("Total Classes Detected:", len(train_generator.class_indices))  # Should print 29

# Save number of classes (should be 29)
num_classes = len(train_generator.class_indices)
print(f"Number of classes: {num_classes}")

# Build the CNN model
model = Sequential([
    Conv2D(32, (3, 3), activation="relu", input_shape=input_shape),
    MaxPooling2D(pool_size=(2, 2)),
    Conv2D(64, (3, 3), activation="relu"),
    MaxPooling2D(pool_size=(2, 2)),
    Flatten(),
    Dense(128, activation="relu"),
    Dropout(0.5),
    Dense(num_classes, activation="softmax")  # Ensure the output layer has 'num_classes' neurons
])

# Compile the model using categorical cross-entropy loss for multi-class classification
model.compile(optimizer="adam", loss="categorical_crossentropy", metrics=["accuracy"])

# Train the model
history = model.fit(
    train_generator,
    steps_per_epoch=train_generator.samples // train_generator.batch_size,
    validation_data=validation_generator,
    validation_steps=validation_generator.samples // validation_generator.batch_size,
    epochs=10  # You may want to increase epochs for better performance
)

# Save the trained model
model.save("asl_model.h5")
print("Model saved as asl_model.h5")

# Plot training history for accuracy
plt.plot(history.history["accuracy"], label="Training Accuracy")
plt.plot(history.history["val_accuracy"], label="Validation Accuracy")
plt.title("Model Accuracy")
plt.xlabel("Epoch")
plt.ylabel("Accuracy")
plt.legend()
plt.show()
