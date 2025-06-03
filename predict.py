import cv2
import numpy as np
import tensorflow as tf
from tensorflow.keras.models import load_model

# Load the trained model
model = load_model("asl_model.h5")

# Get class labels (modify this to match your training data)
class_labels = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "DEL", "NOTHING", "SPACE"]

# Image size (same as training)
img_width, img_height = 64, 64

# Open the webcam
cap = cv2.VideoCapture(0)

while True:
    # Read a frame from the webcam
    ret, frame = cap.read()
    if not ret:
        print("Failed to capture image")
        break

    # Preprocess the frame
    img = cv2.resize(frame, (img_width, img_height))  # Resize
    img = img.astype("float32") / 255.0  # Normalize
    img = np.expand_dims(img, axis=0)  # Expand dims for model input

    # Make prediction
    predictions = model.predict(img)
    predicted_class = np.argmax(predictions)  # Get index of highest probability
    confidence = np.max(predictions)  # Get confidence score

    # Get the corresponding class label
    predicted_label = class_labels[predicted_class]

    # Display the prediction on the frame
    text = f"Predicted: {predicted_label} ({confidence:.2f})"
    cv2.putText(frame, text, (10, 50), cv2.FONT_HERSHEY_SIMPLEX, 1, (0, 255, 0), 2)

    # Show the frame
    cv2.imshow("ASL Recognition", frame)

    # Exit on pressing 'q'
    if cv2.waitKey(1) & 0xFF == ord("q"):
        break

# Release resources
cap.release()
cv2.destroyAllWindows()
