
package examples.`30_Drawing`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.*
import org.openrndr.math.Vector3
import org.openrndr.math.transforms.transform

fun main() {
    application {
        program {
            val geometry = vertexBuffer(vertexFormat {
                position(3)
            }, 3 * 100)
        
            geometry.put {
                for (i in 0 until geometry.vertexCount) {
                    write(Vector3(Math.random() * width, Math.random() * height, 0.00))
                }
            }
        
            extend {
                drawer.shadeStyle = shadeStyle {
                    fragmentTransform = """x_fill.rgb *= vec3(cos(length(v_viewPosition))*0.4+0.6);"""
                }
                drawer.fill = ColorRGBa.PINK.opacify(0.1)
                drawer.vertexBuffer(geometry, DrawPrimitive.TRIANGLES)
            }
        }
    }
}
    