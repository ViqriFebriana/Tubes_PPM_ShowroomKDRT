package id.ac.unpas.tubesshowroomkdrt.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.message
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import com.vanpra.composematerialdialogs.title
import id.ac.unpas.tubesshowroomkdrt.model.SepedaMotor

@Composable
fun SepedaMotorItem (item: SepedaMotor, navController: NavHostController, onDelete: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val subMenus = listOf("Edit", "Delete")
    val confirmationDialogState = rememberMaterialDialogState()

    Card(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate("edit-pengelolaan-motor/" + item.id)
            },
        elevation = 4.dp
    ) {
        Row(modifier = Modifier.padding(15.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Model", fontWeight = FontWeight.Bold)
                Text(text = "Warna", fontWeight = FontWeight.Bold)
                Text(text = "Kapasitas", fontWeight = FontWeight.Bold)
                Text(text = "Tanggal Rilis", fontWeight = FontWeight.Bold)
                Text(text = "Harga", fontWeight = FontWeight.Bold)
            }
            Column(modifier = Modifier.weight(1f)) {
                Text(text = item.model, fontSize = 16.sp)
                Text(text = item.warna, fontSize = 16.sp)
                Text(text = "${item.kapasitas.toString()}cc", fontSize = 16.sp)
                Text(text = item.tanggal_rilis, fontSize = 16.sp)
                Text(text = "Rp. ${item.harga.toString()}", fontSize = 16.sp)
            }
            Column(
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight()
            ) {
                Box(
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                        .clickable {
                            expanded = true
                        }
                ) {
                    Icon(
                        Icons.Default.MoreVert,
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(24.dp),
                        tint = Color.Black
                    )
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    offset = DpOffset(x = (-66).dp, y = (-10).dp)
                ) {
                    subMenus.forEachIndexed { _, s ->
                        DropdownMenuItem(onClick = {
                            expanded = false
                            when (s) {
                                "Edit" -> {
                                    navController.navigate("edit-pengelolaan-motor/${item.id}")
                                }
                                "Delete" -> {
                                    confirmationDialogState.show()
                                }
                            }
                        }) {
                            Text(text = s)
                        }
                    }
                }
            }
        }
    }

    MaterialDialog(dialogState = confirmationDialogState,
        buttons = {
            positiveButton("Ya", onClick = {
                onDelete(item.id)
            })
            negativeButton("Tidak")
        }) {
        title(text = "Konfirmasi")
        message(text = "Yakin Menghapus Data?")
    }
}