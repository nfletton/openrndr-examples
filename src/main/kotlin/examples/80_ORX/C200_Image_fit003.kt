
package examples.`80_ORX`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.loadImage
import org.openrndr.extra.imageFit.FitMethod
import org.openrndr.extra.imageFit.imageFit

import kotlin.math.cos
import kotlin.math.sin

fun main() {
    application {
        program {
            val image = loadImage("data/images/cheeta.jpg")
            extend {
                val margin = 100.0
                drawer.imageFit(image, 20.0, 20.0 + margin / 2, width - 40.0, height - 40.0 - margin, verticalPosition = cos(seconds) * 1.0)
            
                // -- illustrate the placement rectangle
                drawer.fill = null
                drawer.stroke = ColorRGBa.WHITE
                drawer.rectangle(20.0, 20.0 + margin / 2.0, width - 40.0, height - 40.0 - margin)
            }
        }
    }
}
    